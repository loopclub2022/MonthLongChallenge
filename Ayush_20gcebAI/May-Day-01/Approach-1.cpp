// Approach 1 : Using Stack

// Intution : 
// The problem can be thought of having two NOTEPADS and on entering various elements if the content of both notebads is same then intput is true.
// We can simulate this process using stack. On doing backspace the most recent element i.e the top element of stack is deleted.

// T.C : O(n)  (n = max(s.length, t.length))
// S.C : O(n)


class Solution {
public:
    bool backspaceCompare(string s, string t) 
    {
        // Make two stacks (NotePads) for the two strings to simulate the process seperately.
        
        stack<char> ss, st;
        int i = 0;
        
        while(i < s.length() || i < t.length())
        {
            if(i < s.length())
            {
                // If the current element is backspace i.e '#' we will delete the topmost element of stack if it is not empty.
                // Else the current element is pushed into the stack.
                
                if(s[i] == '#' && !ss.empty())
                {
                    ss.pop();
                }
                else if(s[i] != '#')
                {
                    ss.push(s[i]);
                }
            }
            
            if(i < t.length())
            {
                if(t[i] == '#' && !st.empty())
                {
                    st.pop();
                }
                else if(t[i] != '#')
                {
                    st.push(t[i]);
                }
            }
            
            ++i;
        }
        
        if(st.size() != ss.size()) return false;

        // Finally we compare the content of both the stacks (NotePads).
        while(!st.empty() && !ss.empty())
        {
            if(st.top() != ss.top())
                return false;
            
            st.pop();
            ss.pop();
        }
        
        return true;
    }
};