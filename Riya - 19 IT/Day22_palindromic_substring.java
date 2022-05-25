/*
   Question - https://leetcode.com/problems/palindromic-substrings/
   Time Complexity - O(n log n)
   Space Complexity - O(1)
   Approach - We know a palindrome is symmetric from centre, 
              Thus at every index, we assume that is the centre for odd sized string
              and the index is just the right one of centre of even length string.
              
              Therefore, from every index we traverse both in left and right to find the longest palindrome from that index.
*/

class Solution {
    public int countSubstrings(String s) {
        int beg, end, n = s.length(), count =0;
        for(int i =0; i<n;i++)
        {
            beg = i;
            end = i;
            while(beg>=0 && end<n && s.charAt(beg)==s.charAt(end) )
            {
                count++;
                beg--;
                end++;
            }
            beg = i-1;
            end = i;
            while(beg>=0 && end<n && s.charAt(beg)==s.charAt(end) )
            {
                count++;
                beg--;
                end++;
            }
        }
        return count;
        
    }
}
