//You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
//We repeatedly make k duplicate removals on s until we no longer can.
//Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

//Approach ---> 1 : Here the idea is we'll count the occurence . we'll store the element into staack and if it's cout == k then we'll pop out the element till k no.
//at last stack will contain only unique elements .we'll store these element in string named as res 



//T.C - O(N)
//S.C - O(N)
class Solution {
public:
    string removeDuplicates(string s, int k) {
         stack<int>st;
        vector<int>count(s.size(),1);
        st.push(0);
        for(int i = 1; i< s.size(); i++){
            if(!st.empty()){
                if(s[st.top()] == s[i]) count[i] = count[st.top()]+1;
                 
            }
            
                st.push(i);
            if(count[st.top()]== k){
            for(int i =0; i<k; i++){
                st.pop();
            }
        }
        }
        string res = "";
        while(!st.empty()){
            res += s[st.top()];
            st.pop();
        }
      reverse(res.begin(),res.end());
        return res;
    }
};