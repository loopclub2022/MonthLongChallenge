// Question - https://leetcode.com/problems/backspace-string-compare/

/* Time Complexity - O(s.length() + t.length())
    Space Complexity - O(1)
    Explanation - Traversed both s and t in reverse directions such that the final string without # is produced.
                  In the process of strings formation whenever strings are seen to be unequal, 
                  false is returned else true*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1 = s.length() -1, n2 = t.length() - 1, jumps1 = 0, jumps2=0;
        while(n1>=0 || n2>=0)
        {
            while(n1>=0)
            {
                if(s.charAt(n1)=='#')
                {
                    jumps1++;
                    n1--;
                }
                else if(jumps1 > 0)
                {
                    jumps1--;
                    n1--;
                }
                else
                    break;
            }
            while(n2>=0)
            {
                if(t.charAt(n2)=='#')
                {
                    jumps2++;
                    n2--;
                }
                else if(jumps2 > 0)
                {
                    jumps2--;
                    n2--;
                }
                else
                    break;
            }
            if( (n1>=0 && n2<0) || (n1<0 && n2>=0) || (n1>=0 && n2>=0 && s.charAt(n1)!=t.charAt(n2)) )
                return false;
            n1--; n2--;
        }
        return true;
    }
}
