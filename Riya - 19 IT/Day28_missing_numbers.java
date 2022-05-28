/*
   Question - https://leetcode.com/problems/missing-number/
   Time Complexity - O(n)
   Space Complexity - O(1)
   
   Approach - Given that only one number is missing in the array from 0 to n
              For any array of length x, the numbers must be between 0 to x
              Also, we know sum of all numbers from 0 to x = x*(x+1) / 2
              The missing number will hence be equal to -> sum of 0 to x - sum of all numbers
              
*/

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i: nums)  sum+=i;
        int n = nums.length;
        n = (n*(n+1))/2;
        return n-sum;
    }
}
