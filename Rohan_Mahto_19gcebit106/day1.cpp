
/*Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character
  Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Time Complexity-O(n)
space Complexity-O(n) */

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
