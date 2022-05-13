// Approach : Using Level Order Traversal

// Steps : - Maintain a queue of 'Nodes'.
//         - After pushing All nodes of a level, push a NULL Node
//         - Maintain a Prev Node pointing to previous node in Level Order Traversal.
//         - Prev->next = curr
//         - Keep repeating steps till size of queue > 0 i.e Nodes except NULL also exist.
    
// T.C : O(n)  { n : number of nodes }
// S.C : O(n)

class Solution {
public:
    Node* connect(Node* root) 
    {
        if(!root) return root;
        
        queue<Node*> q;
        
        q.push(root);
        q.push(NULL);
        Node* prev = NULL;
        Node* curr = NULL;
        
        while(!q.empty())
        {
            curr = q.front();
            q.pop();
            
            if(prev) prev->next = curr;
            prev = curr;
            
            if(curr != NULL)
            {
                if(curr->left) q.push(curr->left);
                if(curr->right) q.push(curr->right);
            }   
            
            if(curr == NULL && q.size() != 0) q.push(NULL);
        }
        
        return root;
    }
};