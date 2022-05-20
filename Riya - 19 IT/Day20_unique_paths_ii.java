/*
   Question - https://leetcode.com/problems/unique-paths-ii/
   Time Complexity - O(m*n)
   Space Complexity - O(m*n)
   Approach - DP approach , where number of paths possible from the particular point are stored when it is first time visited.
              Later the path possible from down node and right node are added for that node, to give total number of paths from that node.
              
*/

class Solution 
{
    int[][] grid;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        grid = obstacleGrid;
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i<dp.length;i++)
        {
            for(int j = 0;j<dp[0].length;j++)
            {
                dp[i][j] = -1;
            }
        }
        return dfs(0,0);
    }
    
    public int dfs(int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j >=grid[0].length || grid[i][j]==1)
            return 0;
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(i==grid.length - 1 && j==grid[0].length-1 && grid[i][j]==0)
        {
            dp[i][j] = 1;
            return 1;
        }
        dp[i][j] = dfs(i,j+1) + dfs (i+1,j);
        return dp[i][j];
    }
}
