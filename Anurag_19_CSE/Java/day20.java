//Link For Problem: https://leetcode.com/problems/unique-paths-ii/

public class day20 {

    /*
     * TC : O(m*n)
     * 
     * SC : O(m*n)
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1)
            return 0;

        int dp[][] = new int[rows][cols];
        boolean flag = false;

        for (int i = 0; i < cols; i++) {
            if (flag || obstacleGrid[0][i] == 1) {
                flag = true;
                dp[0][i] = 0;
            } else
                dp[0][i] = 1;
        }

        flag = false;

        for (int i = 0; i < rows; i++) {
            if (flag || obstacleGrid[i][0] == 1) {
                flag = true;
                dp[i][0] = 0;
            } else
                dp[i][0] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
