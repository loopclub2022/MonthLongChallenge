/* in push operation enter elements in the queue and push all the remaining elements of the queue i the sameorder again using for loop.We just do this to reverse the order .*/
// tc is O(n)



#include<bits/stdc++.h>
using namespace std;
class MyStack {
public:
    
    queue<int> q;
    MyStack() {
        
    }
    
    void push(int x) {
        q.push(x);
        
        for(int i=0; i<q.size()-1; i++)
        {
            q.push(q.front());
            q.pop();
        }
    }
    
    int pop() {
        
        int x = q.front();
        q.pop();
        return x;
        
    }
    
    int top() 
    {   
        return q.front();   
    }
    
    bool empty() {
        return q.empty();
        
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