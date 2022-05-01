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
