/*
     Question - https://leetcode.com/problems/shortest-path-in-binary-matrix/
     
     Time Complexity - O(mn)
     Space Complexity - O(mn)
     Approach - A bfs algorithm, that just moves forward in all eight directions where 0 is found by increasing distance by 1 at every step and then
                it stores the distance in the queue
                and changes the value of the point to 1 so that we don't go back to it after we have visited a particular point.
                Once we reach the last position, we return the distance it took to reach there.
*/


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] alldir = new int[][]{{1,1},{-1,-1},{1,-1},{-1,1},{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Triplets> q = new LinkedList<Triplets>();
        q.add(new Triplets(0,0,1));
        while(!q.isEmpty())
        {
            int nextzeros = q.size();
            while(nextzeros-->0)
            {
                Triplets temp = q.poll();
                if(temp.i==m-1 && temp.j==n-1)
                    return temp.dis;
                for(int d[] : alldir)
                {
                    int i = temp.i+ d[0];
                    int j = temp.j +d[1];
                    if(i>=0 && i<m && j>=0 && j<n && grid[i][j]==0 )
                    {
                        q.add(new Triplets(i,j,temp.dis+1));
                        grid[i][j]=1;
                    }
                }
            }
        }
        return -1;
    }
}

class Triplets
{
    int i;
    int j;
    int dis;
    public Triplets(int i ,int j, int dis)
    {
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
    public Triplets()
    {}
}
