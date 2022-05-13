//Link For Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class day13 {

    /*
     * TC : O(n)
     * 
     * SC : O(n)
     */

    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node dummy = new Node(0);

            while (size-- > 0) {
                Node current = q.poll();
                dummy.next = current;
                dummy = dummy.next;

                if (current.left != null)
                    q.offer(current.left);

                if (current.right != null)
                    q.offer(current.right);
            }
        }

        return root;
    }

    /*
     * TC : O(n)
     * 
     * SC : O(1)
     */

    public Node spaceOptimized(Node root) {
        if (root == null)
            return null;

        Node head = root;

        while (head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;

            while (head != null) {

                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }

                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }

                head = head.next;
            }

            head = dummy.next;
        }

        return root;
    }

    /*
     * TC : O(n)
     * 
     * SC : O(1)
     */

    public Node anotherSolution(Node root) {
        if (root == null)
            return null;

        Node dummyHead = new Node(0); // this head will always point to the first element in the current layer we are
                                      // searching
        Node pre = dummyHead; // this 'pre' will be the "current node" that builds every single layer
        Node real_root = root; // just for return statement

        while (root != null) {

            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }

            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }

            root = root.next;

            if (root == null) { // reach the end of current layer
                pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in
                                 // next layer
                root = dummyHead.next; // root comes down one level below to the first available non null node
                dummyHead.next = null; // reset dummyhead back to default null
            }
        }

        return real_root;
    }
}
