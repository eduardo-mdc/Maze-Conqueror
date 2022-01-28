package handler;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyStroke;
import element.Element;
import element.Static.*;
import element.dynam.Hero;
import element.position.Position;
import element.position.PositionInterface;
import game.GameInterface;
import maze.MazeInterface;

/**
 * Class used to handle the hero's behaviour in the game.
 *  @author Eduardo Correia
 *  @author Alberto Serra
 *  @author José Carvalho
 */
public class HeroHandler {
    private Hero hero;
    private MazeInterface maze;
    private GameInterface game;

    private LevelHandler levelHandler;
    /**
     * Constructor for the hero handler class
     * @param hero hero to handle
     * @param maze maze class to interact with
     */
    public HeroHandler(Hero hero, MazeInterface maze) {
        this.hero = hero;
        this.maze = maze;
        game = maze.getGame();

    }
    /**
     * Checks the type of the tile
     * @param position tile to check
     */
    public void checkTile(PositionInterface position) {
        int index;
        if (position.equals(maze.getEnding())) {
            maze.getGame().winGame();
            return;
        } else {
            if (checkElement(position, RedPath.class, maze.getStaticElems()) != -1) {
                takeDamage();
            } else if (checkElement(position, Wall.class, maze.getStaticElems()) != -1) {
                return;
            }
            index = checkElement(position, Portal.class, maze.getStaticElems());
            if (index != -1) {
                Portal portal = (Portal) maze.getStaticElems().get(index);
                teleportHero(maze.getPortalHandler().getOtherPortal(portal));
                return;
            }
            index = checkElement(position, Coin.class, maze.getCoins());
            if (index != -1) {
                maze.getCoinsHandler().obtainCoin(index);
                moveHero(position);
                return;
            }
        }
        moveHero(position);
    }
    /**
     * Reduces the health of the hero
     */
    public void takeDamage() {
        levelHandler = game.getLevelHandler();
        int level = levelHandler.getLevel();
        if (!game.isInvincible()) {
            hero.heroTakesDamage();
            maze.getGame().getPointsHandler().incrementPoints(-100 + (int) (level * 0.10));
            maze.loadHearts();
        }
        if (hero.isDead()) {
            maze.getGame().gameOver();
        }
    }
    /**
     * Moves the hero to a given portal
     * @param portal portal to teleport hero to
     */
    public void teleportHero(Portal portal) {
        maze.getPath().add(new Path(hero.getPosition(), "YELLOW", SGR.BOLD, "{"));
        hero.setPosition(portal.getPosition());
    }
    /**
     * Executes different actions based on a given key
     * @param key key to analise
     */
    public void checkKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> {
                checkTile(hero.moveUp());
                return;
            }
            case ArrowDown -> {
                checkTile(hero.moveDown());
                return;
            }
            case ArrowLeft -> {
                checkTile(hero.moveLeft());
                return;
            }
            case ArrowRight -> {
                checkTile(hero.moveRight());
                return;
            }
        }
        Character charToCompare = key.getCharacter();
        if (charToCompare != null) {
            if (charToCompare.equals('b')) {
                maze.getBombsHandler().generateBomb((Position) hero.getPosition());
            }
        }
    }
    /**
     * Moves the hero to a new position
     * Rewards the hero with points if the new position is an undiscovered one
     * @param position position to move hero to
     */
    public void moveHero(PositionInterface position) {
        if (checkEmpty(hero.getPosition())) {
            levelHandler = game.getLevelHandler();
            int level = levelHandler.getLevel();
            maze.getPath().add(new Path(hero.getPosition(), "YELLOW", SGR.BOLD, "{"));
            game.getPointsHandler().incrementPoints(2 + 1 * (int) (level * 0.5));
            maze.getEmptyTiles().remove(new Position((Position) hero.getPosition()));
        }
        hero.setPosition(position);
    }
    /**
     * Checks if the given position is an undiscovered one
     * @param position position to check
     * @return true or false
     */
    private boolean checkEmpty(PositionInterface position) {
        if (position.equals(maze.getBegin())) return true;
        for (PositionInterface pos : maze.getEmptyTiles()) {
            if (pos.equals(position)) return true;
        }
        return false;
    }

    /**
     * Check if there's an element of a given class at a certain position in a given list.
     *
     * @param position position to check.
     * @param cl       Class type to check
     * @param list     list to check objects.
     * @return corresponding to the existence of a cl object at the given position.
     */
    private int checkElement(PositionInterface position, Class cl, Iterable<StaticElement> list) {
        int counter = 0;
        for (Element tile : list) {
            if (cl.isInstance(tile) && tile.getPosition().equals(position)) return counter;
            counter++;
        }
        return -1;
    }

}
