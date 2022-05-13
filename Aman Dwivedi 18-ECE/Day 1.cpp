https://leetcode.com/problems/backspace-string-compare/
Time: O(N)
Space: O(N)

class Solution {
public:
    
    string solve(string str)
    {
        int l=str.length();
        stack<int> st;
        for(int i=0;i<l;i++)
        {
            if(str[i]!='#')
                st.push(str[i]);
            else if(str[i]=='#'&&!st.empty())
                st.pop();
        }
        string ans="";
        while(!st.empty())
        {
            char ch=st.top();
            ans+=ch;
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
    bool backspaceCompare(string s, string t) {
        
        string s1=solve(s);
        string s2=solve(t);
        
        if(s1==s2)
            return true;
        else
            return false;
        
    }
};
