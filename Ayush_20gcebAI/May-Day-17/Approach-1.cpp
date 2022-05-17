// Approach : Preorder Traversal

// Idea : - Do inorder Traversal in the cloned tree
//        - Find a node whose value equals the target node value
       
// T.C : O(n)
// S.C : O(log(n)) => Recursion Stack Space

class Solution {
public:
    TreeNode* ans = new TreeNode(0);
    
    void inorder(TreeNode* node, TreeNode* target)
    {
        if(node == NULL) return;
        
        if(node->val == target->val) ans = node;
        
        inorder(node->left, target);
        inorder(node->right, target);
    }
    
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) 
    {
        inorder(cloned, target);
        return ans;
    }
};