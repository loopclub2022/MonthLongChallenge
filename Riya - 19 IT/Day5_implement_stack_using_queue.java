/* Question - https://leetcode.com/problems/implement-stack-using-queues/
  For Push ,empty - 
   Time Complexity - O(1)          Space Complexity - O(1)
  For pop - 
    Time Complexity - O(n)         Space Complexity - O(n)
  For top - 
    Time Complexity - O(n)         Space Complexity - O(1)
   Approach - Using a basic LinkedList of Queue Interface of java to perform stack operation
              Last In first out
              Adding element on top position and removing from top position as well.
*/

class MyStack {
    Queue<Integer> list;
    public MyStack() {
       list = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
    }
    
    public int pop() {
        int n = list.size()-1;
        for(int i = 0; i<n;i++)
        {
            list.add(list.peek());
            list.remove();
        }
        int x = list.peek();
        list.remove();
        return x;
    }
    
    public int top() {
        Iterator iterator = list.iterator();
        int x = list.peek();
        while (iterator.hasNext())
        {
            x = (Integer)iterator.next();
        }
        return x;
    }
    
    public boolean empty() {
        return list.isEmpty();
    }
}
