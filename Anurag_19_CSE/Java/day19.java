//Link For Problem: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

import java.util.Arrays;

public class day19 {

    /*
     * DFS + Memoization Approach.
     * 
     * TC : O(n)
     * 
     * SC : O(n)
     */

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int max = 0;

        for (int[] d : dp)
            Arrays.fill(d, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(matrix, i, j, dir, dp));
            }
        }

        return max;
    }

    public int dfs(int[][] arr, int sr, int sc, int[][] dir, int[][] dp) {
        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r < arr.length && c < arr[0].length && r >= 0 && c >= 0 && arr[r][c] > arr[sr][sc])
                count = Math.max(count, dfs(arr, r, c, dir, dp));

        }

        return dp[sr][sc] = count + 1;
    }
}
