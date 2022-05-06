/*

Approach : Using Stack of Pairs : Each pair has the character and it's count of frequency.

Steps : Traverse through all characters
        If current char = char at top of stack => Increment count;
        Now If count = k => pop the stack
        If current char != char at top of stack => push current char to stack with count = 1
        Finally Output the stack in reverse order.
        
T.C : O(n)
S.C : O(n)

*/

class Solution {
public:
    string removeDuplicates(string s, int k) 
    {
        stack<pair<int, char>> st;
        
        for(int i = 0; i < s.length(); ++i)
        {
            if(!st.empty() && st.top().second == s[i])
            {
                ++st.top().first;
                
                if(st.top().first == k)
                    st.pop();
            }
            else
            {
                st.push({1, s[i]});
            }
        }
        
        string ans;
        
        while(!st.empty())
        {
            while(st.top().first--)
            {
                ans += st.top().second;
            }
            
            st.pop();
        }
        
        reverse(ans.begin(), ans.end());
        
        return ans;
    }
};
