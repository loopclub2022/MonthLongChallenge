// link: https://leetcode.com/problems/implement-stack-using-queues/
// 225 Leetcode
/*
    approach:
    used ArrayList to implement stack
    T and S complexities:
    push : T: O(1), O(N): if list gets full, then new list will be created with all items copied
    pop: T: O(1) in our case as we remove the last index only , no need to shift the elements.
    isEmpty: T: O(1)
    top: T: O(1)
    Space : O(N)
 */

import java.util.ArrayList;
public class Day_05_ImplementStackUsingQueues {
    static class MyStack {
        private ArrayList<Integer> arrli;

        public MyStack() {
            arrli = new ArrayList<Integer>();
        }

        public void push(int x) {
            arrli.add(x);
        }

        public int pop() {
            if(this.empty()) return -1;
            int ele = arrli.get(arrli.size()-1);
            arrli.remove(arrli.size()-1);
            return ele;
        }

        public int top() {
            if(this.empty()) return -1;
            int ele = arrli.get(arrli.size()-1);
            return ele;
        }

        public boolean empty() {
            return arrli.size() == 0 ? true : false;
        }
    }
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(11);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2+" "+param_3+" "+param_4);
    }
}
