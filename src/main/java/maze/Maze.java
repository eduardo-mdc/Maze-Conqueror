package maze;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import element.Element;
import element.dynam.Hero;
import element.position.Position;
import element.position.PositionInterface;
import element.stat.Path;
import element.stat.Trophy;
import element.stat.Wall;
import game.GameInterface;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze implements MazeInterface {
    final private int xIncr = 10;
    final private int yIncr = 10;
    private Position begin;
    private Position ending;
    private boolean init;
    private GameInterface game;
    private int[][] maze;
    private int dim;
    private Hero hero;
    private ArrayList<Element> elements;
    private ArrayList<Path> path;
    final private String backgroundcolor = "BLUE";

    public Maze(GameInterface game,int dim) {
        //Initialize Variables
        this.game = game;
        this.dim = dim;
        this.begin = begin = new Position(1+xIncr,1+yIncr);
        this.ending = new Position(dim-2+xIncr,dim-2+yIncr);
        init = false;
        elements = new ArrayList<>();
        path = new ArrayList<>();
        hero = new Hero(begin);

        //Generate correct maze
        do {
            MazeGenerator gen = new MazeGenerator(dim - 2);
            gen.generateMaze();
            maze = gen.getIntMaze();
        } while (maze[dim - 3][dim - 3] == 0);

        //Create bigger matrix with outer walls
        maze = load_walls(maze, dim);
        //Create elements and insert them to element list
        createElements();
    }

    static private int[][] load_walls(int[][] map, int dim) {
        int[][] maze = new int[dim][dim];
        for (int i = 1; i < dim - 1; i++) {
            for (int j = 1; j < dim - 1; j++) {
                if (map[i - 1][j - 1] != 0) maze[i][j] = map[i - 1][j - 1];
            }
        }
        return maze;
    }

    private void createElements() {
        createWalls();
        createTrophy();
    }

    public int getDim() {
        return dim;
    }

    public void moveHero(PositionInterface position) {
        if (!endGame(position)) {
            if (canHeroMove(position)){
                path.add(new Path(hero.getPosition()));
                hero.setPosition(position);
            }
        } else {
            game.setState(5);
        }
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());
        }
    }

    public boolean endGame(PositionInterface position) {
        if (position.equals(ending)) return true;
        else return false;
    }

    //TODO E possivel passar por alguns elementos
    private boolean canHeroMove(PositionInterface position) {
        return (position.getX() >= 0 && position.getX() < dim+xIncr) &&
                (position.getY() >= 0 && position.getY() < dim+yIncr) &&
                !elements.contains(new Wall(new Position(position.getX(), position.getY())));
    }

    private void createTrophy() {
        elements.add(new Trophy(ending));
    }

    private void createWalls() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (maze[i][j] == 0) elements.add(new Wall(new Position(i+xIncr, j+yIncr)));
            }
        }
    }

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        screen.fillRectangle(new TerminalPosition(xIncr, yIncr), new TerminalSize(dim, dim), ' ');
        for (Element element : elements)
            element.draw(screen);
        for (Path tile : path)
            tile.draw(screen);
        hero.draw(screen);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }
}
