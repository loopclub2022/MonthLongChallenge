/*
    Question - https://leetcode.com/problems/number-of-1-bits/
*/
/* 
  Approach - To count the number of bits in a number, we will notice that  - 
             for two consecutive integers, there is ony 1 bit difference between them.
             
             Thus, when we perform or operation on a number and its consecutive one, out of all the 1s present, 1 of them is removed.
             For Example- n = 7 = 111
                          n = 7 & 6 = 111 & 110 = 110 = 6
                          n = 6 & 5 = 110 & 101 = 100 = 4
                          n = 4 & 3 = 100 & 011 = 0
                          count = 3, thus 7 has 3 1s.
  Time Complexity - O(log n)
  Space Complexity - O(1)
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0)
        {
            n = n & n-1;
            count++;
        }
        return count;
    }
}
