package handler;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyStroke;
import element.Element;
import element.Static.Path;
import element.Static.RedPath;
import element.Static.StaticElement;
import element.Static.Wall;
import element.dynam.Hero;
import element.position.PositionInterface;
import maze.Maze;

import java.util.List;

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
            if (checkElement(position, RedPath.class,maze.getStaticElems())) {
                takeDamage();
                return;
            }
            if (!checkElement(position, Wall.class,maze.getStaticElems())) {
                moveHero(position);
            }
        }
    }

    public void takeDamage(){
        hero.heroTakesDamage();
        maze.loadHearts();
        if (hero.isDead()){
            hero.setHealth(heroHealth);
            maze.getGame().gameOver();
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
        if (!checkElement(hero.getPosition(),Path.class,maze.getPath()) && !checkElement(hero.getPosition(),RedPath.class,maze.getStaticElems()))
            maze.getPath().add(new Path(hero.getPosition(), "YELLOW", SGR.BOLD, "{"));
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
    private boolean checkElement(PositionInterface position, Class cl, List<StaticElement> list) {
        for (Element tile : list) {
            if (cl.isInstance(tile) && tile.getPosition().equals(position)) return true;
        }
        return false;
    }

}
