// Approach : Using Stack 

// Idea : Coverting given list to a List of integer and maintaining the result in a stack.
//        The main idea is to do Depth First Search until no element is left.
//        Push each integer to the stack.
//        The top of stack gives the value of next.

class NestedIterator {
public:
    stack<NestedInteger> st;
    NestedIterator(vector<NestedInteger> &nestedList) 
    {
        for(int i = nestedList.size() - 1; i >= 0; --i)
            st.push(nestedList[i]);
    }
    
    int next() 
    {
        int num = st.top().getInteger();
        st.pop();
        return num;
    }
    
    bool hasNext() 
    {
        while(!st.empty())
        {
            NestedInteger curr = st.top();
            
            if(curr.isInteger())
            {
                return true;
            }
            
            st.pop();
            
            vector<NestedInteger> temp = curr.getList();
            
            for(int i = temp.size() - 1; i >= 0; --i)
            {
                st.push(temp[i]);
            }
        }
        
        return false;
    }
};
