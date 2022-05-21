# Link For Problem: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

import functools


class Solution:

    """
        DFS + Memoization Approach.

        TC : O(n)

        SC : O(n)
    """

    def longestIncreasingPath(self, matrix: list[list[int]]) -> int:
        R, C = len(matrix), len(matrix[0])

        g = [[[] for _ in range(C)] for _ in range(R)]

        for i in range(R):

            for j in range(C):

                for (r, c) in ((i+1, j), (i-1, j), (i, j+1), (i, j-1)):

                    if 0 <= r < R and 0 <= c < C and matrix[r][c] > matrix[i][j]:
                        g[i][j].append((r, c))

        @functools.lru_cache(None)
        def helper(i, j):
            return 1 + max(helper(r, c) for r, c in g[i][j]) if g[i][j] else 1

        return max(helper(i, j) for i in range(R) for j in range(C))
