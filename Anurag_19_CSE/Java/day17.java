//Link For Problem: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class day17 {

    /*
     * Apply Simple DFS or BFS Algorithm.
     * For every Node, check if it is the target node.
     * 
     * TC : O(n)
     * 
     * SC : O(n) {Recursion call Stack.}
     */

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target || original == null)
            return cloned;

        TreeNode left = original.left;
        TreeNode cloneLeft = cloned.left;

        TreeNode checkLeft = getTargetCopy(left, cloneLeft, target);
        if (checkLeft != null)
            return checkLeft;

        TreeNode right = original.right;
        TreeNode cloneRight = cloned.right;

        TreeNode checkRight = getTargetCopy(right, cloneRight, target);

        return checkRight;
    }
}
