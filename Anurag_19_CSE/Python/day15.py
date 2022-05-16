# Link For Problem : https://leetcode.com/problems/deepest-leaves-sum/

from collections import deque
from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    """
      First Solution Involves BFS traversal.

      Keep a sum pointer and keep resetting it to 0
      in each iteration.
      By this, sum will only contain the sum of deepest leaves(leaf nodes) after
      the loop ends.

      TC : O(n)

      SC : O(n)
    """

    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        q: deque[TreeNode] = deque()
        q.append(root)

        sum: int = 0
        while(q):
            size: int = len(q)
            sum = 0

            while(size > 0):
                temp: TreeNode = q.popleft()
                sum += temp.val

                if temp.left:
                    q.append(temp.left)

                if temp.right:
                    q.append(temp.right)

                size -= 1

        return sum

    """
      Second Solution involves DFS traversal.
      
      Maintain a deep variable pointing to the deepest level currently processed.
      Maintain a depth variable pointing to the current level being processed.
      Rest is Self Explanatory.
      
      TC : O(n)
      
      SC : O(1)
    """

    def dfs(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        def dfs(root, depth):

            if not root:
                return

            if not root.left and not root.right:

                if depth > self.deep:
                    self.deep = depth
                    self.ans = root.val

                elif depth == self.deep:
                    self.ans += root.val

                return

            dfs(root.left, depth + 1)
            dfs(root.right, depth + 1)

            return

        self.deep, self.ans = -1, 0
        dfs(root, 0)

        return self.ans
