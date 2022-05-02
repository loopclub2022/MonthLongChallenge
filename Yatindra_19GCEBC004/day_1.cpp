class Solution {
public:
    bool backspaceCompare(string s, string t) {
        string s1="";
        string t1="";
        stack <char> s_char;
        stack <char> t_char;
        for(int i=0;i<s.length();i++){
            if(s[i]=='#' && !s_char.empty()){
                s_char.pop();
            }
            else if(s[i]!='#'){
                s_char.push(s[i]);
            }
        }
        for(int j=0;j<t.length();j++){
            if(t[j]=='#' && !t_char.empty()){
                t_char.pop();
            }
            else if(t[j]!='#'){
                t_char.push(t[j]);
            }
        }
        while(!s_char.empty()){
            s1=s_char.top()+s1;
            s_char.pop();
        }
        while(!t_char.empty()){
            t1=t_char.top()+t1;
            t_char.pop();
        }
        if(s1.compare(t1)==0){
            return true;
        }
        else{
            return false;
        }
    }
};