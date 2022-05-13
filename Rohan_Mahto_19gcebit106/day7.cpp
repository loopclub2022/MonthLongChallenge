class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char,int>>st;
        for(auto a:s)
        {
            if(st.empty() or st.top().first!=a)
            {
                st.push({a,1});
            }
            else
            {
                st.top().second++;
                if(st.top().second==k)
                {
                    st.pop();
                }
                
                
            }
            
        }
        string finals="";
        while(!st.empty())
        {
            for(int i=0;i<st.top().second;i++)
            {
                finals+=st.top().first;
            }
            st.pop();
        }
        reverse(finals.begin(),finals.end());
        return finals;
        
    }
};