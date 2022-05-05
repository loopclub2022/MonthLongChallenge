//Link For Problem: https://leetcode.com/problems/implement-stack-using-queues/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class day5 {

    /*
     * Use Deque.
     * Simply Add To Front.
     * Remove from Front.
     * Peek Front.
     * 
     * TC:
     * 1. Push : O(1)
     * 2. Pop : O(1)
     * 3. Top : O(1)
     * 4. Empty : O(1)
     * 
     * SC: O(n)
     * 
     */

    class MyStack {

        private Deque<Integer> dq;

        public MyStack() {
            dq = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            dq.addFirst(x);
        }

        public int pop() {
            return dq.pollFirst();
        }

        public int top() {
            return dq.peek();
        }

        public boolean empty() {
            return dq.isEmpty();
        }
    }

    /*
     * Use Singly Ended Queue.
     * 
     * For Push Operation, Reverse
     * the entire queue untill the last
     * element (Recently added) becomes the
     * front.
     * 
     * TC:
     * 1. Push : O(n)
     * 2. Pop : O(1)
     * 3. Top : O(1)
     * 4. Empty : O(1)
     * 
     * SC: O(n)
     */

    class UsingQueue {

        private Queue<Integer> q;

        public UsingQueue() {
            q = new LinkedList<Integer>();
        }

        public void push(int x) {
            q.offer(x);

            int size = q.size();

            while (size-- > 1)
                q.offer(q.remove());
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }

    }
}
