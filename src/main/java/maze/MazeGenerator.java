package maze;

import element.position.Position;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;

/**
 * Class which contains an algorithm to generate a random maze, represented by an array of ones and zeros. Code sourced
 * from https://github.com/oppenheimj/maze-generator
 *
 * @author oppenheimj
 */
public class MazeGenerator {
    private final Stack<Node> stack = new Stack<>();
    private final Random rand = new Random();
    private final int[][] maze;
    private final int dimension;

    public MazeGenerator(int dim) {
        maze = new int[dim][dim];
        dimension = dim;
    }

    public void generateMaze() {
        stack.push(new Node(new Position(0, 0)));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                maze[next.getY()][next.getX()] = 1;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
            }
        }
    }

    public int[][] getIntMaze() {
        return maze;
    }

    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.getY() - 1; y < node.getY() + 2; y++) {
            for (int x = node.getX() - 1; x < node.getX() + 2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && maze[y][x] == 1) {
                    numNeighboringOnes++;
                }
            }
        }
        return (numNeighboringOnes < 3) && maze[node.getY()][node.getX()] != 1;
    }

    private void randomlyAddNodesToStack(ArrayList<Node> nodes) {
        int targetIndex;
        while (!nodes.isEmpty()) {
            targetIndex = rand.nextInt(nodes.size());
            stack.push(nodes.remove(targetIndex));
        }
    }

    private ArrayList<Node> findNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (int y = node.getY() - 1; y < node.getY() + 2; y++) {
            for (int x = node.getX() - 1; x < node.getX() + 2; x++) {
                if (pointOnGrid(x, y) && pointNotCorner(node, x, y)
                        && pointNotNode(node, x, y)) {
                    neighbors.add(new Node(new Position(x, y)));
                }
            }
        }
        return neighbors;
    }

    private Boolean pointOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < dimension && y < dimension;
    }

    private Boolean pointNotCorner(Node node, int x, int y) {
        return (x == node.getX() || y == node.getY());
    }

    private Boolean pointNotNode(Node node, int x, int y) {
        return !(x == node.getX() && y == node.getY());
    }
}