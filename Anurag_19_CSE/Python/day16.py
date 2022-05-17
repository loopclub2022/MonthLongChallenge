# Link For Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/

from collections import deque


class Solution:

    """
        Apply Standard BFS Algorithm.

        TC : O(mn)

        SC : O(mn)
    """

    def shortestPathBinaryMatrix(self, grid: list[list[int]]) -> int:
        if grid[0][0] or grid[-1][-1]:
            return -1

        row: int = len(grid)
        col: int = len(grid[0])

        q = deque()
        q.append((0, 0, 1))

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1),
                      (-1, -1), (-1, 1), (1, 1), (1, -1)]

        grid[0][0] = 1

        while q:
            size = len(q)

            while(size > 0):
                r, c, moves = q.popleft()

                if r == row-1 and c == col-1:
                    return moves

                for x, y in directions:
                    nextX = r+x
                    nextY = c+y

                    if nextX >= 0 and nextY >= 0 and nextX < row and nextY < col and grid[nextX][nextY] == 0:
                        q.append((nextX, nextY, moves+1))
                        grid[nextX][nextY] = 1

                size -= 1

        return -1
