//TC -->O(n)

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char,int>> st;
    
    for(int i=0;i<s.length();i++){

        //if stack is non empty an char in stack is equal to element in string at pos then
        //increment the int in stack by 1 
        //again check if the top of stack(int) is equal to K then pop the element. 
        if(!st.empty() && st.top().first==s[i]){
            ++st.top().second;
            if(st.top().second==k)
                st.pop();
        }
        else
            st.push({s[i],1});
    }

    //created a string res to print the ans
    string res="";
    while(!st.empty()){
        for(int i=1;i<=st.top().second;i++)
            res+=st.top().first;
        st.pop();
    }
    //becoz the stack  is LIFO so use reverse fun. to get the ans string . 
    reverse(res.begin(),res.end());
    return res;
    }
};