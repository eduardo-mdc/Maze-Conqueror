package maze;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import com.googlecode.lanterna.input.KeyStroke;
import game.GameInterface;
import handler.*;
import element.Element;
import element.dynam.Hero;
import element.position.Position;
import element.position.PositionInterface;
import element.Static.*;

import java.util.*;

/**
 * Maze class which contains the elements that make up the game, this includes, but is not limited to, static elements such as hero, path, walls, other special
 * game objects and the actual maze in matrix form, generated from the MazeGenerator class.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public class Maze implements MazeInterface {
    final private int xIncr;
    final private int yIncr;
    private int counter;
    private PositionInterface begin;
    private final PositionInterface ending;
    private final GameInterface game;
    private int[][] maze;
    private int dim;
    private Hero hero;
    private List<StaticElement> staticElems;
    private List<PositionInterface> emptyTiles;
    private List<Heart> hp;
    private List<StaticElement> coins;
    private Queue<StaticElement> path;
    private Queue<Bomb> bombs;
    private HeroHandler heroHandler;
    private PortalHandler portalHandler;
    private int currentHealth;


    private BombsHandler bombsHandler;


    private CoinsHandler coinsHandler;
    final private String backgroundcolor = "BLACK";

    /**
     * Constructor for the maze class. Requires a game class in which the maze shall be used and an appropriate dimension.
     *
     * @param game game class in which the maze is to be used in.
     * @param dim  dimension integer which dictates the maze's size.
     */
    public Maze(GameInterface game, int dim) {
        this.game = game;
        this.dim = dim;
        xIncr = 5;
        yIncr = 8;
        this.begin = new Position(1 + xIncr, 1 + yIncr);
        this.ending = new Position(dim - 2 + xIncr, dim - 2 + yIncr);
        counter = 0;
        currentHealth = game.getHeroHp();
        hp = new ArrayList<>();
        staticElems = new LinkedList<>();
        emptyTiles = new LinkedList<>();
        path = new LinkedList<>();
        coins = new LinkedList<>();
        bombs = new LinkedList<>();
        hero = new Hero(begin, "GREEN", SGR.BORDERED, "@", currentHealth);
        heroHandler = new HeroHandler(hero, this);
        bombsHandler = new BombsHandler(this);
        getMaze(dim);
        maze = load_walls(maze, dim);
        createElements();
    }

    @Override
    public int getxIncr() {
        return xIncr;
    }

    @Override
    public int getyIncr() {
        return yIncr;
    }

    @Override
    public PositionInterface getBegin() {
        return begin;
    }

    @Override
    public void getMaze(int dim) {
        MazeGenerator gen = null;
        do {
            gen = new MazeGenerator(dim - 2);
            gen.generateMaze();
            maze = gen.getIntMaze();
        } while (maze[dim - 3][dim - 3] == 0);
    }

    @Override
    public PositionInterface getEnding() {
        return ending;
    }

    @Override
    public List<StaticElement> getStaticElems() {
        return staticElems;
    }

    @Override
    public Queue<StaticElement> getPath() {
        return path;
    }

    @Override
    public GameInterface getGame() {
        return game;
    }

    @Override
    public int[][] load_walls(int[][] map, int dim) {
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
        loadHearts();
        createWalls();
        createTrophy();
        createPortals();
        createCoins();
    }

    @Override
    public int getDim() {
        return dim;
    }

    @Override
    public void nextFrame(KeyStroke key) {
        counter++;
        bombsHandler.tickAllBombs();
        if (key != null)
            heroHandler.checkKey(key);
        if (counter == 10) {
            createRedPath();
            counter = 0;
        }

    }

    @Override
    public LevelHandler getLevelhandler() {
        return game.getLevelHandler();
    }


    @Override
    public void createTrophy() {
        staticElems.add(new Trophy(ending, "#F3CA28", SGR.BOLD, "$"));
    }

    @Override
    public void createWalls() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (!(i == 1 && j == 1) && !(i == dim - 2 && j == dim - 2)) {
                    if (maze[i][j] == 0) {
                        if (i == 0 || j == 0 || i == dim - 1 || j == dim - 1) {
                            staticElems.add(new Wall(new Position(i + xIncr, j + yIncr), "#FFFFFF", SGR.BOLD, "#", true));
                        }
                        staticElems.add(new Wall(new Position(i + xIncr, j + yIncr), "#FFFFFF", SGR.BOLD, "#"));
                    } else if (maze[i][j] == 1)
                        emptyTiles.add(new Position(i + xIncr, j + yIncr));
                }
            }
        }
    }
    @Override
    public void setHeroHp(int newHP) {
        hero.setHealth(newHP);
    }

    @Override
    public int getActualHeroHp() {
        return hero.getHealth();
    }

    @Override
    public void createRedPath() {
        if (path.size() != 0) {
            PositionInterface pathPosition = path.remove().getPosition();
            staticElems.add(new RedPath(pathPosition, "RED", SGR.BOLD, "{"));
        }
    }

    @Override
    public void createPortals() {
        portalHandler = new PortalHandler(this);
        staticElems.add(portalHandler.getPortalA());
        staticElems.add(portalHandler.getPortalB());
    }

    @Override
    public void createCoins() {
        coinsHandler = new CoinsHandler(this);
        for (int i = 0; i < dim / 10; i++) {
            coinsHandler.generateCoin();
        }
    }

    @Override
    public void loadHearts() {
        hp.clear();
        for (int i = 1; i <= hero.getHealth(); i++) {
            hp.add(new Heart(new Position(i + 17, 2), "#FF0000", SGR.BOLD, "*"));
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
        for (Element tile : path)
            tile.draw(screen);
        for (Element coin : coins)
            coin.draw(screen);
        for (Element bomb : bombs)
            bomb.draw(screen);
        bombsHandler.draw(screen);
        loadHearts();
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


    @Override
    public List<PositionInterface> getEmptyTiles() {
        return emptyTiles;
    }

    @Override
    public PortalHandler getPortalHandler() {
        return portalHandler;
    }

    @Override
    public List<StaticElement> getCoins() {
        return coins;
    }

    @Override
    public CoinsHandler getCoinsHandler() {
        return coinsHandler;
    }

    @Override
    public Queue<Bomb> getBombs() {
        return bombs;
    }

    @Override
    public BombsHandler getBombsHandler() {
        return bombsHandler;
    }

    @Override
    public HeroHandler getHeroHandler() {
        return heroHandler;
    }

    @Override
    public Hero getHero() {
        return hero;
    }


}

