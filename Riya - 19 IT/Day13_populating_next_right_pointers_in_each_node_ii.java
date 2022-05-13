/*
    Question - https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    
    Time Complexity - O(n)
    Space Complexity - O(h) - if H is the hieghgt of the tree
    Approach - The solution uses the basic level order traversal of the tree.
               First we calculate the height of the tree, thereby forming a array of nodes, containing the left node at evelry level.
               For Example - if tree is 
               
                                1
                               / \
                              2   3
                             /\    \
                            4  5    6
                            
               Then the Array of Nodes will be 
               |1|                                                                              |1|               |1|
               |2|                                                                              |3|               |3|
               |4|... While traversing we found 3, 5 then connect, 2 to 3 and 4 to 5 then ...   |5|... further .. |6|
               
               Thus connecting every node with its next in same level.
*/


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Queue<Node> q = new LinkedList<>();
    public Node connect(Node root) {
        int h = height(root);
        Node[] l = new Node[h];
        for(int i = 0;i<h;i++)
        {
            l[i] = null;
        }
        level(l, h,root);
        return root;
    }
    
    public void level(Node[] l, int height, Node root)
    {
        if(height==0)
            return;
        if(root==null)
            return;
        if(l[height-1]!=null)
        {
            l[height-1].next = root;
        }
        l[height-1] = root;
        level(l,height-1,root.left);
        level(l,height-1,root.right);
    }
    
    public int height(Node root)
    {
        if(root==null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        
        if(lheight>rheight)
            return ++lheight;
        else
            return ++rheight;
    }
}
