/*Problem statement : Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

    void push(int x) Pushes element x to the top of the stack.
    int pop() Removes the element on the top of the stack and returns it.
    int top() Returns the element on the top of the stack.
    boolean empty() Returns true if the stack is empty, false otherwise.

Notes:

    You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

*/
#include <bits/stdc++.h>

using namespace std;

/*Time Complexity : 
	push - θ(n)
	pop - θ(1)
	top - θ(1)
	empty - θ(1)

Approach : every time we push an element we are left rotating the queue by n-1 elements 
where n is current size of the queue (after inserting the new element)

By doing so we will have our queue elements in order of most recent inserted element in front followed by previously inserted element
thus we will have our LIFO stack ready

Now for all other operations we can use basic queue methods like - front(),pop(),empty()

*/

class MyStack {
	queue<int> myQueue;
public:
    MyStack() {
        
    }
    
    void push(int x) {
        myQueue.push(x);
        for(int i=0;i<myQueue.size()-1;i++){
        	int temp = myQueue.front();
        	myQueue.push(temp);
        	myQueue.pop();
        }
    }
    
    int pop() {
       	int x = myQueue.front();
        myQueue.pop();
        return x;
    }
    
    int top() {
        return myQueue.front();  
    }
    
    bool empty() {
        return myQueue.empty();
    }
};

/*
Code for testing on local machine

int main(void){
	MyStack myStack;
	myStack.push(1);
	myStack.push(2);
	cout<<myStack.top()<<endl; // return 2
	cout<<myStack.pop()<<endl; // return 2
	cout<<myStack.top()<<endl; // return 1
	cout<<boolalpha<<myStack.empty()<<endl; // return False
	return 0;
}*/