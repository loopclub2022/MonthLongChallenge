//Given two strings s and t, return true if they are equal when both are typed into empty text editors.
// '#' means a backspace character.

//Approach  --> Using two stacks
 bool backspaceCompare(string s, string t) {
       stack<int>st;  
        stack<int>st1;
        for(int i =0; i<s.size(); i++){
            if(s[i] == '#' && st.size() != 0)
                st.pop();
            else if(s[i] != '#')
                st.push(s[i]);
        }
         for(int i =0; i<t.size(); i++){
            if(t[i] == '#' && st1.size() != 0)
                st1.pop();
            else if(t[i] != '#')
                st1.push(t[i]);
        }
        
        while(!st.empty() && !st1.empty()){
              if( st.top() != st1.top()) return false;
                  st.pop();
                  st1.pop();
            
        }
        
        if(st1.size() == st.size()) return true;
        else return false;
        
    }
};

 
