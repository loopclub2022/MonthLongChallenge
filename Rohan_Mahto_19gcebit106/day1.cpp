class Solution {
public:
    bool backspaceCompare(string s, string t) {
       string s1="";
        string s2="";
        int i=0;
        int j=0;
        while(i<s.length() or j<t.length())
        {
            if(i<s.length())
            {
                if(s[i]=='#')
                {
                   if(s1.size()>0)
                   {
                       s1.pop_back();
                   }
                }
                else
                {
                    s1.push_back(s[i]);
                }
                i++;
            }
            if(j<t.length())
            {
                if(t[j]=='#')
                {
                   if(s2.size()>0)
                   {s2.pop_back();
                   }
                }
                else
                {
                    s2.push_back(t[j]);
                }
                j++;
            }
        }
        return s1==s2;
        
    }
};