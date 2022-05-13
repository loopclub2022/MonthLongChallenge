class Solution {
public:
    Node* connect(Node* root) {
        if (!root)
            return root;
        queue<Node*> q;
        q.push(root);
        q.push(NULL);
       while(q.size()>1)
       {
           Node*p=q.front();
           q.pop();
           if(!p)
           {
               q.push(nullptr);
               continue;
           }
           p->next=q.front();
           if(p->left)
           {
               q.push(p->left);
           }
           if(p->right)
           {
               q.push(p->right);
           }
       }
        return root;
        
    }
};