/* Question - https://leetcode.com/problems/implement-stack-using-queues/
  For Push - 
   Time Complexity - O(1)          Space Complexity - O(1)
  For pop - 
    Time Complexity - O(n)         Space Complexity - O(1)
  For top - 
    Time Complexity - O(n)         Space Complexity - O(1)
  For empty - 
    Time Complexity - O(1)         Space Complexity - O(1)
   Approach - Using a basic LinkedList of java to perform stack operation
              Last In first out
              Adding element on top position and removing from top position as well.
*/

class MyStack {
    LinkedList<Integer> list;
    public MyStack() {
       list = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
    }
    
    public int pop() {
        int x = list.remove(list.size()-1);
        return x;
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public boolean empty() {
        if(list.size()==0)
            return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
