/*
    Question - https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
    Time Complexity - O(n)
    Space Complexity - O(1)
    Approach - Inorder Traversal is used to traverse both original amd cloned tree and then 
               when the target node is found in the cloned tree we return the found target node.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original != null) {
            if (target == original) {
                return cloned;
            }
            else {
                TreeNode left = getTargetCopy(original.left, cloned.left, target);
                if (left == null) return getTargetCopy(original.right, cloned.right, target);
                return left;
            }
        }
        return null;
    }
}
