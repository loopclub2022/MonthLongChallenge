/* 
   Question - https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
   
   Time Complexity - 0(m*n)
   Space Complexity - O(m*n)
   Approach -  Using dp approach, calculating the distance from each node, and storing it in a dp matrix
*/

class Solution 
{
    static int[][] dp;
    int[][] dir = {{1,0},{-1,0}, {0,1}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) 
    {
       dp = new int[matrix.length][matrix[0].length];
        int distance = 0;
        for(int i = 0; i <matrix.length;i++)
        {
            for(int j = 0; j< matrix[0].length;j++)
            {
                distance = Math.max(distance, dfs(i,j,matrix));
            }
        }
        return distance;
    }
    
    public int dfs(int i, int j, int[][] matrix)
    {
        if(dp[i][j]!=0)
            return dp[i][j];
        for(int d[] : dir)
        {
            int x = d[0]+i;
            int y = d[1]+j;
            if(x>=0 && x< matrix.length && y>=0 && y < matrix[0].length && matrix[x][y]>matrix[i][j])
            {
                dp[i][j] = Math.max(dp[i][j], dfs(x,y,matrix));
            }
        }
        return ++dp[i][j];
    }
}
