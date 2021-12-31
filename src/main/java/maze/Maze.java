package maze;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import element.Element;
import element.dynam.Hero;
import element.position.Position;
import element.position.PositionInterface;
import element.stat.End;
import element.stat.Wall;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private boolean init;
    private int[][] maze;
    private int dim;
    private Hero hero;
    private ArrayList<Element> elements;
    final private String backgroundcolor = "#000000";

    public Maze(int dim){
        init = false;
        hero = new Hero(1, 1);
        elements = new ArrayList<>();
        this.dim = dim;
        do {
            MazeGenerator gen = new MazeGenerator(dim-2);
            gen.generateMaze();
            maze = gen.getIntMaze();
        }while (maze[dim-3][dim-3] == 0);
        maze = load_walls(maze,dim);
        createElements();
    }

    static private int[][] load_walls(int[][] map , int dim){
        int[][] maze = new int [dim][dim];
        for(int i = 1 ; i < dim-1; i++ ){
            for (int j = 1; j < dim-1;j++) {
                if (map[i-1][j-1] != 0 )maze[i][j] = map[i-1][j-1];
            }
        }
        return maze;
    }

    private void createElements() {
        createWalls();
        createEnd();
    }

    private void createWalls() {
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                if(maze[i][j] == 0) elements.add(new Wall(i,j));
            }
        }
    }
    public int getDim(){
        return dim;
    }
    public void moveHero(PositionInterface position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }


    public PositionInterface moveUp() {
        return new Position(hero.getPosition().getX(), hero.getPosition().getY() - 1);
    }

    public PositionInterface moveDown() {
        return new Position(hero.getPosition().getX(), hero.getPosition().getY() + 1);
    }

    public PositionInterface moveLeft() {
        return new Position(hero.getPosition().getX() - 1, hero.getPosition().getY());
    }

    public PositionInterface moveRight() {
        return new Position(hero.getPosition().getX() + 1, hero.getPosition().getY());
    }

    //TODO E possivel passar por alguns elementos
    private boolean canHeroMove(PositionInterface position) {
        return (position.getX() >= 0 && position.getX() < dim) &&
                (position.getY() >= 0 && position.getY() < dim) &&
                !elements.contains(new Wall(position.getX(), position.getY()));
    }

    private void createEnd(){
        elements.add(new End(dim-2,dim-2));
    }

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(dim, dim), ' ');
        hero.draw(screen);
        for (Element element : elements)
            element.draw(screen);
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
