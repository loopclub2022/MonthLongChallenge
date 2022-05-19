# Link For Problem: https: // leetcode.com/problems/critical-connections-in-a-network/


class Solution:

    """ 
        TC : O(V+E)

        SC : O(V)
    """

    def criticalConnections(self, n: int, connections: list[list[int]]) -> list[list[int]]:

        # node is index, neighbors are in the list
        graph = [[] for i in range(n)]

        # build graph
        for n1, n2 in connections:
            graph[n1].append(n2)
            graph[n2].append(n1)

        # min_discovery_time of nodes at respective indices from start node
        # 1. default to max which is the depth of continuous graph
        lows = [n] * n

        # critical edges
        critical = []

        # args: node, node discovery_time in dfs, parent of this node
        def dfs(node, discovery_time, parent):

            # if the low is not yet discovered for this node
            if lows[node] == n:

                # 2. default it to the depth or discovery time of this node
                lows[node] = discovery_time

                # iterate over neighbors
                for neighbor in graph[node]:

                    # all neighbors except parent
                    if neighbor != parent:

                        expected_discovery_time_of_child = discovery_time + 1
                        actual_discovery_time_of_child = dfs(
                            neighbor, expected_discovery_time_of_child, node)

                        # nothing wrong - parent got what was expected => no back path
                        # this step is skipped if there is a back path
                        if actual_discovery_time_of_child >= expected_discovery_time_of_child:
                            critical.append((node, neighbor))

                        # low will be equal to discovery time of this node or discovery time of child
                        # whichever one is minm
                        # if its discovery time of child - then there is a backpath
                        lows[node] = min(
                            lows[node], actual_discovery_time_of_child)

            # return low of this node discovered previously or during this call
            return lows[node]

        dfs(n-1, 0, -1)

        return critical
