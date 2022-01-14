package maze;
import element.position.Position;
import java.util.ArrayDeque;
import java.util.Queue;

//Adapted from https://www.techiedelight.com/lee-algorithm-shortest-path-in-a-maze/

public class ShortestPath {
    private int[][] grid;
    private int i;
    private int j;
    private int x;
    private int y;
    private int dim;
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};
    private boolean[][] visited;


    ShortestPath(int[][] grid, int dim, Position begin, Position end) {
        this.grid = grid;
        this.i = begin.getX();
        this.j = begin.getY();

        this.x = end.getX();
        this.y = end.getY();

        this.dim = dim;
    }

    class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] == 1 && !visited[row][col];
    }

    private int findShortestPathLength() {
        visited = new boolean[dim][dim];
        visited[i][j] = true;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(i, j, 0));

        int min_dist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (i == x && j == y) {
                min_dist = dist;
                break;
            }
            for (int k = 0; k < 4; k++) {
                if (isValid(grid, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;

    }

    public int getShortPath() {
            return findShortestPathLength();
    }
}



