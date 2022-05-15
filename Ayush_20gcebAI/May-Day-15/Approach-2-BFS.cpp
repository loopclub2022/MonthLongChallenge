// Approach : Level Order Traversal

// Idea : - keep sum of all nodes of current level
//        - If next level exist make sum = 0
//        - Store next level's node's sum
//        - If next level doesn't exist return sum

// T.C : O(n)
// S.C : O(n)

class Solution {
public:
    int deepestLeavesSum(TreeNode* root) 
    { 
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);    // Null is used to seperate each level of the tree in the queue.
        
        int sum = 0;
        
        while(!q.empty())
        {
            TreeNode* curr = q.front();
            q.pop();
            
            if(q.empty()) break;    // Indicates all nodes are processed. curSum = sum of last level.
            
            if(curr) 
            {
                sum += curr->val;   
                
                if(curr->left) q.push(curr->left);
                if(curr->right) q.push(curr->right);   
            }
            else
            {
                // Indicates that current is ended and there is another level which is present. 
                // Thus currSum is of no use.
                // All the values of the next level would have been already pushed to the queue.
                // Thus pushing a NULL to indicate end of next level.
                
                q.push(NULL);    
                sum = 0;
            }
        } 
        
        return sum;
    }
};