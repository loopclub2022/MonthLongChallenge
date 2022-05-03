// Question - https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
/*  Time Complexity  - O(n) 
    Space Complexity - O(1) 
    Explanation -  If array - {2, 6, 4, 8, 10, 9, 15} then for max loop 
                   end = 6 as for index 5, it is the last index where max and nums[i] don't match max = 10 and nums[i]=9 and
                   for 2nd (min) loop
                   start = 1 as it is the initial index where min and nums[i] don't match , min = 4 and nums[i] = 6 
                   thus length of unsorted array is end - start*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0], min = nums[nums.length - 1];
        int start = 0, end =0;
        for(int i =0; i<nums.length ; i++)
        {
            if(nums[i]>max)
                max = nums[i];
            if(max!=nums[i])
                end = i+1;
        }
        for(int i = nums.length - 1; i>=0 ; i--)
        {
            if(nums[i]<min)
                min = nums[i];
            if(min!=nums[i])
                start = i;
        }
        return end - start;
    }
}
