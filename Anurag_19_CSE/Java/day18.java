// Link For Problem: https: // leetcode.com/problems/critical-connections-in-a-network/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day18 {

    /*
     * TC : O(V+E)
     * 
     * SC : O(V)
     */

    static int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer> graph[] = new ArrayList[n];
        int disc[] = new int[n];

        Arrays.fill(disc, -1);
        int low[] = new int[n];

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (List<Integer> c : connections) {
            int src = c.get(0);
            int dest = c.get(1);
            graph[src].add(dest);
            graph[dest].add(src);
        }

        int parent[] = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1)
                bridge(i, disc, low, parent, graph, res);
        }

        return res;
    }

    void bridge(int u, int disc[], int low[], int parent[], List<Integer> graph[], List<List<Integer>> res) {
        disc[u] = low[u] = time;
        time += 1;

        for (int v : graph[u]) {
            if (v == u)
                continue;

            if (disc[v] == -1) {
                parent[v] = u;
                bridge(v, disc, low, parent, graph, res);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
