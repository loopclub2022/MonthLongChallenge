//Push:O(1)
//Pop:O(N)
//Top:O(1)
//Empty:O(1)

class MyStack {
public:
    queue <int> queuebhai;
    int topBhai=-1;
    MyStack() {
        
    }
    
    void push(int x) {
        topBhai=x;
        queuebhai.push(x);
    }
    
    int pop() {
        int sizebhai=queuebhai.size();
        sizebhai-=1;
        while(sizebhai--){
            topBhai=queuebhai.front();
            queuebhai.push(topBhai);
            queuebhai.pop();
        }
        topBhai=queuebhai.front();
        queuebhai.pop();
        return topBhai;
    }
    
    int top() {
        return queuebhai.back();
    }
    
    bool empty() {
        return queuebhai.size()==0;
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
