//Given two binary trees original and cloned and given a reference to a node target in the original tree.

// The cloned tree is a copy of the original tree.

// Return a reference to the same node in the cloned tree.

// Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

 //Approach --> We've given original tree, cloned tree (which is a copy of original one), and target 
 //so what we can do here like, if original tree is empty means null , then cloned one will also null ,so if it's null then we can directly return the cloned;
 //and if we traverse the cloned tree and found the same value as target in that tree then we'll store for reference
 //else traversed the whole cloned tree;

// T.C - O(n)
//S.c = O(h) --> height of tree

 /**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
        TreeNode* res;
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
    
     if(cloned == NULL) return cloned;
        if(cloned -> val == target->val)
            res = cloned;
        getTargetCopy(original,cloned->left,target);
        getTargetCopy(original,cloned->right,target);
        return res;
    }
};