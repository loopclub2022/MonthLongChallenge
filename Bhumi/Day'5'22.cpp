//Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

//Approach --> Here i'm taking two queues and as we know queue is based on FIFO principle so let's take an eg of three elements
// 3 4 5 in qu1 ...if we pop out element from qu1 to qu2 the qu2 will have element in this manner as 5 4 3 ..hence now we pop out element from q2 then it'll be 5 similarly we'll do for others
   

class MyStack {
public:

    queue<int>qu1;
    queue<int>qu2;
    MyStack() {
        
        
    }
    
    void push(int x) {
        qu2.push(x);
        while(!qu1.empty()){
            qu2.push(qu1.front());
            qu1.pop();
        }
        swap(qu1,qu2);
    }
    
    int pop() {
        int res = top();
        qu1.pop();
        return res;
    }
    
    int top() {
        return qu1.front();
    }
    
    bool empty() {
        return qu1.empty();
    }
};
 

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */