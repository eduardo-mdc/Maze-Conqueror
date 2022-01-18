package handler;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyStroke;
import element.Element;
import element.Static.*;
import element.dynam.Hero;
import element.position.PositionInterface;
import game.GameInterface;
import maze.MazeInterface;


public class HeroHandler {
    private Hero hero;
    private MazeInterface maze;
    private GameInterface game;
    private final int heroHealth = 5;


    public HeroHandler(Hero hero, MazeInterface maze) {
        this.hero = hero;
        this.maze = maze;
        game = maze.getGame();
        hero.setHealth(heroHealth);
    }

    public void checkTile(PositionInterface position) {
        if (position.equals(maze.getEnding())) {
            maze.getGame().winGame();
            return;
        } else {
            if (checkElement(position, RedPath.class, maze.getStaticElems())) {
                takeDamage();
                return;
            }
            else if (checkElement(position, Wall.class, maze.getStaticElems())) {
                return;
            }
            else if (checkElement(position, Portal.class, maze.getStaticElems())) {

            }
        }
        moveHero(position);
    }

    public void takeDamage() {
        hero.heroTakesDamage();
        maze.getGame().getPointsHandler().incrementPoints(-130);
        maze.loadHearts();
        if (hero.isDead()) {
            hero.setHealth(heroHealth);
            maze.getGame().gameOver();
        }
    }

    public void checkKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> checkTile(hero.moveUp());
            case ArrowDown -> checkTile(hero.moveDown());
            case ArrowLeft -> checkTile(hero.moveLeft());
            case ArrowRight -> checkTile(hero.moveRight());
            case Enter -> maze.generateBombs(hero.getPosition().getX(), hero.getPosition().getY());
            case Delete -> maze.generateCoin(hero.getPosition().getX(), hero.getPosition().getY());
        }
    }


    public void moveHero(PositionInterface position) {
        if (!checkElement(hero.getPosition(), Path.class, maze.getPath()) && !checkElement(hero.getPosition(), RedPath.class, maze.getStaticElems())) {
            maze.getPath().add(new Path(hero.getPosition(), "YELLOW", SGR.BOLD, "{"));
            game.getPointsHandler().incrementPoints(2);
        }
        if (checkElement(hero.getPosition(), Coin.class, maze.getStaticElems()))
            game.getPointsHandler().incrementPoints(2); // trying to gain points when he gets a coin
        hero.setPosition(position);
    }

    /**
     * Check if there's an element of a given class at a certain position in a given list.
     *
     * @param position position to check.
     * @param cl       Class type to check
     * @param list     list to check objects.
     * @return corresponding to the existence of a cl object at the given position.
     */
    private boolean checkElement(PositionInterface position, Class cl, Iterable<StaticElement> list) {
        for (Element tile : list) {
            if (cl.isInstance(tile) && tile.getPosition().equals(position)) return true;
        }
        return false;
    }

}
