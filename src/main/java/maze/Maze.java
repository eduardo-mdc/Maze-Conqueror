package maze;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;
import element.stat.End;
import element.stat.Wall;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private int[][] maze;
    private int dim;
    private ArrayList<Element> elements;
    final private String backgroundcolor = "#000000";

    public Maze(int dim){
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

    private void createEnd(){
        elements.add(new End(dim-2,dim-2));
    }

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(dim, dim), ' ');

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
