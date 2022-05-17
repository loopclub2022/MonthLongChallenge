# Link For Problem: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    """
        Apply Simple DFS or BFS Algorithm.
        For every Node, check if it is the target node.

        TC : O(n)

        SC : O(n) {Recursion call Stack.}
    """

    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if not original:
            return None

        if original is target:
            return cloned

        return self.getTargetCopy(original.left, cloned.left, target) or self.getTargetCopy(original.right, cloned.right, target)

    def another_solution(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if cloned.val == target.val:
            return cloned

        if cloned.left:
            res = self.getTargetCopy(original, cloned.left, target)

            if res:
                return res

        if cloned.right:
            res = self.getTargetCopy(original, cloned.right, target)

            if res:
                return res

        return None
