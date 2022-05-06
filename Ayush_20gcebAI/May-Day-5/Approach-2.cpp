/*

Appraoch : Only One Queue

Steps : 
1 : Push : Push element to queue
           Reverse the queue
           
2 : Pop  : Return front of queue
           Delete front

3 : Top  : Return front of queue

4 : Empty: If queue is empty return TRUE

Complexity :

T.C : Push - O(n)
      Pop  - O(1)
      Top  - O(1)
      
S.C : Push - O(1)
      Pop  - O(1)
      Top  - O(1)

*/

class MyStack {    
public:
    queue<int> q;
    MyStack() {   
    }
    
    void push(int x) 
    {
        q.push(x);
        
        int size = q.size();
        
        while(size-- > 1)
        {
            int num = q.front();
            q.pop();
            q.push(num);
        }
    }
    
    int pop() 
    {
        int num = q.front();
        q.pop();
        return num;
    }
    
    int top() 
    {
        return q.front();
    }
    
    bool empty() 
    {
        return q.empty();
    }
};
