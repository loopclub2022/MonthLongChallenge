//Link For Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.LinkedList;

public class day16 {

    /*
     * Apply Standard BFS Algorithm.
     * 
     * TC : O(mn)
     * 
     * SC : O(mn)
     */

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;

        int row = grid.length, col = grid[0].length;

        if (grid[row - 1][col - 1] == 1)
            return -1;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int current[] = q.poll();

                if (current[0] == row - 1 && current[1] == col - 1)
                    return current[2];

                for (int d[] : dir) {
                    int nextX = current[0] + d[0];
                    int nextY = current[1] + d[1];

                    if (nextX >= 0 && nextY >= 0 && nextX < row && nextY < col && grid[nextX][nextY] == 0) {
                        q.offer(new int[] { nextX, nextY, current[2] + 1 });
                        grid[nextX][nextY] = 1;
                    }
                }
            }
        }

        return -1;
    }
}
