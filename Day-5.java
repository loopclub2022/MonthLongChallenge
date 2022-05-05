/*
Time complexities:
push: O(N)
pop: O(1)
peek: O(1)
isEmpty: O(1)
*/

class MyStack {
    private Queue<Integer> q ;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        for(int i=1; i<q.size(); i++)
            q.offer(q.poll());
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

