package handler;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyStroke;
import element.Element;
import element.Static.Path;
import element.Static.RedPath;
import element.Static.Wall;
import element.dynam.Hero;
import element.position.PositionInterface;
import maze.Maze;

public class HeroHandler {
    private Hero hero;
    private Maze maze;
    private final int heroHealth = 5;


    public HeroHandler(Hero hero, Maze maze){
        this.hero = hero;
        this.maze = maze;
        hero.setHealth(heroHealth);
    }

    public void checkTile(PositionInterface position) {
        if (position.equals(maze.getEnding())) {
            maze.getGame().winGame();
            return;
        } else {
            if (checkElement(position, RedPath.class)) {
                hero.heroTakesDamage();
                maze.loadHearts();
                if (hero.isDead()){
                    hero.setHealth(heroHealth);
                    maze.getGame().gameOver();
                }
                return;
            }
            if (!checkElement(position, Wall.class)) {
                moveHero(position);
            }
        }
    }

    public void checkKey(KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowUp -> checkTile(hero.moveUp());
            case ArrowDown -> checkTile(hero.moveDown());
            case ArrowLeft -> checkTile(hero.moveLeft());
            case ArrowRight -> checkTile(hero.moveRight());
        }
    }

    public void moveHero(PositionInterface position) {
        if (!checkPath(hero.getPosition()) && !checkElement(hero.getPosition(),RedPath.class))
            maze.getPath().add(new Path(hero.getPosition(), "YELLOW", SGR.BOLD, "{"));
        hero.setPosition(position);
    }

    /**
     * Checks if there's a Path object at a given position.
     *
     * @param position position to check.
     * @return boolean corresponding to the existence of a Path object.
     */
    private boolean checkPath(PositionInterface position) {
        for (Element tile : maze.getPath()) {
            if (tile instanceof Path)
                if (tile.getPosition().equals(position)) return true;
        }
        return false;
    }

    /**
     * Check if there's an element of a given class at a certain position in staticElems
     *
     * @param position position to check.
     * @param cl       Class type to check
     * @return corresponding to the existence of a cl object at the given position.
     */
    private boolean checkElement(PositionInterface position, Class cl) {
        for (Element tile : maze.getStaticElems()) {
            if (cl.isInstance(tile) && tile.getPosition().equals(position)) return true;
        }
        return false;
    }

}
