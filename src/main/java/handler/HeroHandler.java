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


public class HeroHandler {
    private Hero hero;
    private MazeInterface maze;
    private GameInterface game;

    private LevelHandler levelHandler;
    public HeroHandler(Hero hero, MazeInterface maze) {
        this.hero = hero;
        this.maze = maze;
        game = maze.getGame();

    }

    public void checkTile(PositionInterface position) {
        int index;
        if (position.equals(maze.getEnding())) {
            maze.getGame().winGame();
            return;
        } else {
            if (checkElement(position, RedPath.class, maze.getStaticElems()) != -1) {
                takeDamage();
            }
            else if (checkElement(position, Wall.class, maze.getStaticElems()) != -1) {
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

    public void takeDamage() {
        levelHandler = game.getLevelHandler();
        int level = levelHandler.getLevel();

        if(!game.isInvincible()){
            System.out.printf("DAMAGE!");
            hero.heroTakesDamage();
            maze.getGame().getPointsHandler().incrementPoints(-100 + (int)(level*0.10));
            maze.loadHearts();
        }


        if (hero.isDead()) {
            maze.getGame().gameOver();
        }
    }

    private void teleportHero(Portal portal){
        maze.getPath().add(new Path(hero.getPosition(), "YELLOW", SGR.BOLD, "{"));
        hero.setPosition(portal.getPosition());
    }

    public void checkKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> checkTile(hero.moveUp());
            case ArrowDown -> checkTile(hero.moveDown());
            case ArrowLeft -> checkTile(hero.moveLeft());
            case ArrowRight -> checkTile(hero.moveRight());
            case Enter -> maze.getBombsHandler().generateBomb((Position) hero.getPosition());
        }
    }

    public void moveHero(PositionInterface position) {
        if (checkEmpty(hero.getPosition())){
            levelHandler = game.getLevelHandler();
            int level = levelHandler.getLevel();
            maze.getPath().add(new Path(hero.getPosition(), "YELLOW", SGR.BOLD, "{"));
            game.getPointsHandler().incrementPoints(2 * (int)(level*0.5));
            maze.getEmptyTiles().remove(new Position((Position) hero.getPosition()));
        }
        hero.setPosition(position);
    }

    private boolean checkEmpty(PositionInterface position){
        if(position.equals(maze.getBegin())) return true;
        for (Position pos : maze.getEmptyTiles()){
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
