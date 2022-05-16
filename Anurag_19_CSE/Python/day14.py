# Link For Problem: https://leetcode.com/problems/network-delay-time/

from collections import defaultdict
import heapq


class Solution:

    """
      Simply Apply Dijkstra Algotithm.

      TC : O(N+ElogN)

      SC: O(N+E)
    """

    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        adj_list = defaultdict(list)

        for x, y, w in times:
            adj_list[x].append((w, y))

        visited = set()
        heap = [(0, k)]

        while heap:
            travel_time, node = heapq.heappop(heap)
            visited.add(node)

            if len(visited) == n:
                return travel_time

            for time, adjacent_node in adj_list[node]:

                if adjacent_node not in visited:
                    heapq.heappush(heap, (travel_time+time, adjacent_node))

        return -1
