/*  Used two queue, for pop operation- O(n) and for top element -O(1) */

class MyStack {
public:
    queue<int>p1,p2;
    MyStack() {   
    } 
    void push(int x) {
        p1.push(x);
            
    } 
    int pop() {
        while(p1.size()>1)
        {
            p2.push(p1.front());
            p1.pop();
        }
        int x=p1.front();
        p1.pop();
        while(p2.size()>0)
        {
            p1.push(p2.front());
            p2.pop();
        }
        return x;
        
    }
    
    int top() {
        return p1.back();
        
    }
    
    bool empty() {
        return p1.empty();
        
    }
};