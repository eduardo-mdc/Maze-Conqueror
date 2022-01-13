package maze;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import element.Element;
import element.dynam.Hero;
import element.position.Position;
import element.position.PositionInterface;
import element.Static.*;
import game.GameInterface;
import handler.HeroHandler;
import handler.PointsHandler;

import java.util.*;

/**
 * Maze class which contains the elements that make up the game, this includes, but is not limited to, static elements such as hero, path, walls, other special
 * game objects and the actual maze in matrix form, generated from the MazeGenerator class. This class is also responsible for managing the directional inputs received by the
 * player and verifying the state of the game.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public class Maze implements MazeInterface {
    final private int xIncr = 5;
    final private int yIncr = 8;
    private int counter;
    private Position begin;
    private final Position ending;
    private final GameInterface game;
    private int[][] maze;
    private int dim;
    private Hero hero;
    private List<StaticElement> staticElems;
    private List<Heart> hp;
    private Queue<Path> path;
    private HeroHandler heroHandler;
    final private String backgroundcolor = "BLACK";
    private PointsHandler pointsHandler;
    private List<Position> visited;

    //TODO change hero constructor to accept starting hp as a variable and the correspondent tests

    /**
     * Constructor for the maze class. Requires a game class in which the maze shall be used and an appropriate dimension.
     *
     * @param game game class in which the maze is to be used in.
     * @param dim  dimension integer which dictates the maze's size.
     */
    public Maze(GameInterface game, int dim) {
        //Initialize Variables
        this.game = game;
        this.dim = dim;
        this.begin = new Position(1 + xIncr, 1 + yIncr);
        this.ending = new Position(dim - 2 + xIncr, dim - 2 + yIncr);
        counter = 0;
        hp = new ArrayList<>();
        staticElems = new LinkedList<>();
        path = new LinkedList<>();
        hero = new Hero(begin, "GREEN", SGR.BORDERED, "@");
        heroHandler = new HeroHandler(hero,this);
        pointsHandler = game.getPointsHandler();

        //Generate correct maze with the chosen algorithm
        do {
            MazeGenerator gen = new MazeGenerator(dim - 2);
            gen.generateMaze();
            maze = gen.getIntMaze();
        } while (maze[dim - 3][dim - 3] == 0);

        //Create bigger matrix with outer walls
        maze = load_walls(maze, dim);
        //Create elements and insert them to element list
        createElements();
        System.out.println(shortestPath(begin,ending));
    }


    public int shortestPath(Position IncrementedStart, Position IncrementedEnd){
        Position start = new Position(IncrementedStart);
        Position end = new Position(IncrementedEnd);
        VisitedCell initialPoint = new VisitedCell(start.getX(),start.getY(),0);
        Queue<VisitedCell> queue = new LinkedList<>();
        queue.add(initialPoint);

        VisitedCell cell = null;

        boolean[][] isVisited = new boolean[dim][dim];
        isVisited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            cell = queue.remove();

            if (cell.getRow() == end.getX() && cell.getCol() == end.getY()) return cell.getDist(); // destination found

            if (canCross(cell.getRow() - 1, cell.getCol(), isVisited)) { // move up
                queue.add(new VisitedCell(cell.getRow() - 1, cell.getCol(), cell.getDist() + 1));
                isVisited[cell.getRow() - 1][cell.getCol()] = true;
            }
            if (canCross(cell.getRow() + 1, cell.getCol(), isVisited)) { // move down
                queue.add(new VisitedCell(cell.getRow() + 1, cell.getCol(), cell.getDist() + 1));
                isVisited[cell.getRow() + 1][cell.getCol()] = true;
            }
            if (canCross(cell.getRow(), cell.getCol() - 1, isVisited)) { // move left
                queue.add(new VisitedCell(cell.getRow(), cell.getCol() - 1, cell.getDist() + 1));
                isVisited[cell.getRow()][cell.getCol() - 1] = true;
            }
            if (canCross(cell.getRow(), cell.getCol() + 1, isVisited)) { // move right
                queue.add(new VisitedCell(cell.getRow(), cell.getCol() + 1, cell.getDist() + 1));
                isVisited[cell.getRow()][cell.getCol() + 1] = true;
            }
        }
        return cell.getDist();
    }

    private  boolean canCross(int x, int y, boolean[][] isVisited) {
        if (x >= 0 && y >= 0 && x <dim && y < dim && maze[x][y] != '0' && isVisited[x][y] == false) {
            return true;
        }
        return false;
    }

    public Position getEnding() {
        return ending;
    }

    public List<StaticElement> getStaticElems() {
        return staticElems;
    }

    public List<StaticElement> getPath() {
        return (List)path;
    }

    public GameInterface getGame() {
        return game;
    }

    /**
     * Function to encapsulate the raw integer maze matrix in the value 0 (which corresponds to a Wall).
     *
     * @param map raw integer maze generated by the maze generator.
     * @param dim integer dimension for the output maze.
     * @return returns a new raw integer maze in which the outer layers have the value of 0.
     */
    private static int[][] load_walls(int[][] map, int dim) {
        int[][] maze = new int[dim][dim];
        for (int i = 1; i < dim - 1; i++) {
            for (int j = 1; j < dim - 1; j++) {
                if (map[i - 1][j - 1] != 0) maze[i][j] = map[i - 1][j - 1];
            }
        }
        return maze;
    }

    @Override
    public void createElements() {
        createHpBar();
        createWalls();
        createTrophy();
    }
    @Override
    public int getDim() {
        return dim;
    }

    @Override
    public void nextFrame(com.googlecode.lanterna.input.KeyStroke key) {
        counter++;
        if(key!=null){
            heroHandler.checkKey(key);
        }
        if (counter == 10) {
            if(path.size() != 0){
                PositionInterface pathPosition = path.remove().getPosition();
                staticElems.add(new RedPath(pathPosition, "RED", SGR.BOLD, "{"));
            }
            counter = 0;
        }

    }

    /**
     * Creates a Trophy at the ending position of the maze.
     */
    private void createTrophy() {
        staticElems.add(new Trophy(ending, "#F3CA28", SGR.BOLD, "$"));
    }

    /**
     * Creates walls objects corresponding to where the value 0 exists in the raw integer maze.
     */
    private void createWalls() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (maze[i][j] == 0)
                    staticElems.add(new Wall(new Position(i + xIncr, j + yIncr), "#FFFFFF", SGR.BOLD, "#"));
            }
        }
    }

    /**
     * Creates an Hpbar object at the upper-left corner of the terminal.
     */
    private void createHpBar() {
        int xsize = hero.getHealth() + 2;
        int ysize = 3;
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                if (i == 0 || i == xsize - 1 || j == 0 || j == ysize - 1)
                   staticElems.add(new HpBar(new Position(i + 1, j + 1), "#FFFFFF", SGR.BOLD, "-"));

            }
        }
        loadHearts();
    }

    //TODO change hearts to be stored to a stack instead.

    /**
     * Creates hearts objects corresponding to the current hp of the Hero object.
     */
    public void loadHearts() {
        hp.clear();
        for (int i = 1; i <= hero.getHealth(); i++) {
            hp.add(new Heart(new Position(i + 1, 2), "#FF0000", SGR.BOLD, "*"));
        }
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        screen.fillRectangle(new TerminalPosition(xIncr, yIncr), new TerminalSize(dim, dim), ' ');
        for (Element element : hp)
            element.draw(screen);
        for (Element element : staticElems)
            element.draw(screen);
        for (Path tile : path)
            tile.draw(screen);
        loadHearts();
        hero.draw(screen);
    }

    /**
     * Transforms the raw integer maze to string form.
     *
     * @return raw integer maze in string form.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }
}

