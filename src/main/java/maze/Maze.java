package maze;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze implements MazeInterface {
    final private int xIncr = 50;
    final private int yIncr = 15;
    private int counter;
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
    //todo change hero constructor to accept starting hp as a variable and the correspondent tests
    private int heroHealth = 5;


    public Maze(GameInterface game,int dim) {
        //Initialize Variables
        this.game = game;
        this.dim = dim;
        this.begin = begin = new Position(1+xIncr,1+yIncr);
        this.ending = new Position(dim-2+xIncr,dim-2+yIncr);
        init = false;
        counter = 0;
        elements = new ArrayList<>();
        path = new ArrayList<>();
        hero = new Hero(begin);
        hero.setHealth(heroHealth);

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
        createHpBar();
        createWalls();
        createTrophy();
    }

    public int getDim() {
        return dim;
    }

    public void checkTile(PositionInterface position) {
        if(position.equals(ending)){
            winGame();
            return;
        }
        else{
            if(checkRedPath(position)){
                System.out.println("ouch");
            }
            if (!checkWall(position)){
                moveHero(position);
            }
        }
    }

    public void moveHero(PositionInterface position){
        counter++;
        path.add(new Path(hero.getPosition()));
        hero.setPosition(position);
        if(counter == 2){
            PositionInterface pathPosition = path.remove(0).getPosition();
            elements.add(new RedPath(pathPosition));
            counter = 0;
        }
    }

    public void winGame(){
        game.setState(5);
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp -> checkTile(hero.moveUp());
            case ArrowDown -> checkTile(hero.moveDown());
            case ArrowLeft -> checkTile(hero.moveLeft());
            case ArrowRight -> checkTile(hero.moveRight());
        }
    }
    
    private boolean checkWall(PositionInterface position) {
        for (Element tile : elements) {
            if (tile instanceof Wall)
                if (tile.getPosition().equals(position)) return true;
        }
        return false;
    }

/*
    //Generic Implementation of checkElement
    private <T> boolean checkElement(PositionInterface position) {
        for (Element tile : elements) {
            if (tile instanceof T)
                if (tile.getPosition().equals(position)) return true;
        }
        return false;
    }
*/


    private boolean checkRedPath(PositionInterface position) {
        for (Element tile : elements){
            if (tile instanceof RedPath)
                if(tile.getPosition().equals(position)) return true;
        }
        return false;
    }

    private boolean checkPath(PositionInterface position) {
        return elements.contains(new Path(new Position(position.getX(), position.getY())));
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

    private void createHpBar(){
        int xsize = hero.getHealth() + 2 ;
        int ysize = 3;
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                if (i == 0 || i == xsize-1 || j == 0 || j == ysize-1) elements.add(new HpBar(new Position(i+1, j+1)));
            }
        }
        loadHearts();
    }

    private void loadHearts() {
        for (int i = 1 ; i <= hero.getHealth();i++){
            elements.add(new Heart(new Position(i+1, 2)));
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
