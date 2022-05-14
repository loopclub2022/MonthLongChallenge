/*
   Question - https://leetcode.com/problems/network-delay-time/
   Time Complexity - O(n+times.length) , as the Given graph has n nodes i.e n vertex and times.length edges.
   Space Complexity - O(n) 
   
   Approach - A simple dfs algorithm is used, where once the node is visited it is marked true in visited array.
              Simultaneously the minimum time to reach that particular node is also stored in the time array.
              Once we get the time from source node to all the other nodes, maximum of it is returned, (which is the maximum time for signal to travel).
*/


class Solution {
    boolean[] visited;
    int[] time;
    HashMap<Integer,LinkedList<Pair>> ad = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        visited = new boolean[n+1];
        time = new int[n+1];
        for(int[] i : times)
        {
            ad.putIfAbsent(i[0],new LinkedList<Pair>());
            ad.get(i[0]).add(new Pair(i[1], i[2]));
        }
        ad.forEach((source,node)-> Collections.sort(node, new Pair()) );
        Arrays.fill(time,1,n+1,Integer.MAX_VALUE);
        connect(k, 0);
        int max = -1;
        for(int i = 1;i<n+1;i++)
        {
            if(!visited[i])
                return -1;
            max = Math.max(max, time[i]);
        }
        return max;
    }
    
    public void connect(int k, int value)
    {
        if(time[k]<=value)
            return;
        time[k] = value;
        visited[k] = true;
        if(ad.containsKey(k))
           ad.get(k).forEach(node -> connect(node.dest, value + node.weight));
    }
}

class Pair implements Comparator<Pair>
{
    int dest;
    int weight;
    public Pair()
    {}
    public Pair(int d, int w)
    {
        dest = d;
        weight = w;
    }
    public int compare(Pair p1, Pair p2)
    {
        return Integer.compare(p1.weight,p2.weight);
    }
}
