Appraoch : Maintaining Top Element Everytime in one of the two queues.

Steps : 
At starting q1 maintains top element.

1 : Push - Push element in q1.
           Pop the previous element from q1;
           Push this to q2.
           
2 : Pop  - Pop element from q1 : this is the element to be returned.
           Pop n - 1 elements from q2 and push them to q1
           Now onwards q2 will maintain the top element.
           This will change on every pop operation

3 : Top  - I have used flag to check which queue is maintaining top element.
           Flag = false => q1 maintains top
           Flag = true  => q2 maintains top

4 : Empty - Return true if both queues are empty.


Complexity :
T.C : Push - O(1)
      Pop  - O(n)
      Top  - O(1)
      
S.C : Push - O(1)
      Pop  - O(1)
      Top  - O(1)

*/

class MyStack {    
public:
    queue<int> q1, q2;
    bool flag;
    MyStack(): flag(false){
        
    }
    
    void push(int x) 
    {
        if(!flag)
        {
            q1.push(x);
            
            if(q1.size() > 1)
            {
                q2.push(q1.front());
                q1.pop();
            }
        }
        else
        {
            q2.push(x);
            
            if(q2.size() > 1)
            {
                q1.push(q2.front());
                q2.pop();
            }
        }
    }
    
    int pop() 
    {
        int num;
        
        if(!flag)
        {
            num = q1.front();
            q1.pop();
            
            while(q2.size() > 1)
            {
                q1.push(q2.front());
                q2.pop();
            }
            
            flag = true;
        }
        else
        {
            num = q2.front();
            q2.pop();
            
            while(q1.size() > 1)
            {
                q2.push(q1.front());
                q1.pop();
            }
            
            flag = false;
        }
        
        return num;
    }
    
    int top() 
    {
        if(!flag) return q1.front();
        else return q2.front();
    }
    
    bool empty() 
    {
        return q1.empty() && q2.empty();
    }
};