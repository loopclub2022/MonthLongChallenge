/*
   Question - https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
   Time Complexity - O(n*k)
   Space Complexity - O(2^k)
   Approach - Every substring of size k is stored in a set,
              as set does not allow duplicacy,
              then when the size of set is checked, if it is 2^k, then all substring is present.
*/

class Solution 
{
    public boolean hasAllCodes(String s, int k) 
    {
        HashSet<String> all = new HashSet<String>(); 
        for(int i =k;i<=s.length();i++)
            all.add(s.substring(i-k,i));
        if(all.size()==Math.pow(2,k))  return true;
        return false;
    }
}
