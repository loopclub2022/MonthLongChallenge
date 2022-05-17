// link: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
// 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
/**
    T: O(N)
    S: O(1)
    Approach: Traverse(DFS) and check for equal target
**/
class Solution {
    private TreeNode helper(TreeNode original, TreeNode cloned, TreeNode target){
        if(original == null){
            return null;
            
        }
        
        TreeNode lft = helper(original.left, cloned.left, target);
        TreeNode rgt = helper(original.right, cloned.right, target);
        
        // if(target.val == cloned.val){
        if(target==original){
            return cloned;
        }
        if(lft != null){
            return lft;
        }
        else if(rgt != null){
            return rgt;
        }
        else{
            return null;
        }
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(original, cloned, target);
    }
}