https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
Time: O(N)
Space: O(N)

class Solution {
public:
    string removeDuplicates(string s, int k) {

        int n=s.size();
        stack<pair<char,int>> st; //take frequency stack to store every element
        for(int i=0;i<n;i++)
        {
            //if first char is not there or equal to top, then add 
            if(st.empty()||st.top().first!=s[i])
                st.push({s[i],1});
            else
            {
                //if it is there we increase its count
                auto ele=st.top();
                st.pop();
                st.push({s[i],ele.second+1});
            }
            //if its freq == k, then we remove it
            if(st.top().second==k)
                st.pop();
        }
        //take empty string to store result
        string res="";
        while(!st.empty())
        {
            while(st.top().second--)
                res+=st.top().first;

            st.pop();
        }
        //as chars are stored in reverse order, we reverse the string
        reverse(res.begin(),res.end());
        return res;

    }
};g
