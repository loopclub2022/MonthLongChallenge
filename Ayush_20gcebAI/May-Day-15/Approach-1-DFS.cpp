// Approach : Preorder Traversal + Map

// Idea : - Do Preorder Traversal and Keep account of the level of depth.
//        - Add the node value corresponding to each level into the map.
//        - Finally return the last value on the "ordered" map

// T.C : O(n) {n => number of nodes in Tree}
// S.C : O(n) + O(n) => Map Space + Stack Space

class Solution {
private:
    void preorder(TreeNode* node, int level, map<int, int>& mp)
    {
        if(node == NULL) return;
        
        mp[level] += node->val;
        
        preorder(node->left, level + 1, mp);
        preorder(node->right, level + 1, mp);
    }
    
public:
    int deepestLeavesSum(TreeNode* root) 
    {
        map<int, int> mp;
        int ans;
        
        preorder(root, 1, mp);
        
        for(auto val : mp)
        {
            ans = val.second;
        }
        
        return ans;
    }
};