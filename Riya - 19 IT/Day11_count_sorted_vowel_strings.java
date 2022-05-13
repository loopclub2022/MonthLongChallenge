/* Question - https://leetcode.com/problems/count-sorted-vowel-strings/
   Time Complexity - O(n)
   Space Complexity - O(1) 
   
   Approach -   We see that for n = 1 , Strings are - "a", "e", "i", "o", "u" -> 5
                For n = 2, if we fix the first letter a i.e, "a_" -> To fill underscore we have 5 options, i.e answer of n=1 "a,e,i,o,u"
                                                      e i.e, "e_" -> To fill underscore we have 4 options, i.e "e,i,o,u"
                                                      i i.e, "i_" -> To fill underscore we have 3 options, i.e "i,o,u"
                                                      o i.e, "o_" -> To fill underscore we have 2 options, i.e "o,u"
                                                      u i.e, "u_" -> To fill underscore we have 1 option,  i.e, "u"
                       Answer for n= 2 is 5+4+3+2+1 = 14
                       
                For n = 3, if we fix 1st letter a, i.e, "a _ _" -> To fill 2 dashes we have = 5+4+3+2+1= 15 options
                                                e, i.e, "e _ _" -> To fill 2 dashes we have = 4+3+2+1 = 10 options
                                                i, i.e, "i _ _" -> To fill 2 dashes we have = 3+2+1 = 6 options
                                                o, i.e, "o _ _" -> To fill 2 dashes we have = 2+1 = 3 options
                                                u, i.e, "u _ _" -> To fill 2 dashes we have = 1 = 1 options
                                                
                From here we realised, we only need the count of just last n-1 to caculate n
                Thus we use a 5*2 array to store these values
                in 1st column, stored n-1 all values,
                then calculate values for n in 2nd column
                and store them back to 1st column, so that we can calculate for n+1
                
   */

class Solution {
    public int countVowelStrings(int n) {
        int dp[][] = new int [5][2];
        for(int j = 0;j<5;j++)
            dp[j][0] = 1;
        int sum1 = 5, sum2 = 0;
        for(int i = 1;i<n;i++)
        {
            sum2=sum1;
            sum1 = 0;
            for(int j = 0;j<5;j++)
            {
                dp[j][1] = sum2;
                sum2 -=dp[j][0];
                sum1 += dp[j][1];
            }
            for(int j = 0;j<5;j++)
            {
                dp[j][0] = dp[j][1];
            }
        }
        return sum1;
    }
}
