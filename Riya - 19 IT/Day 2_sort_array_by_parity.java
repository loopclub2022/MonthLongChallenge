//   Question - https://leetcode.com/problems/sort-array-by-parity/

/* Time Complexity - O(N)
   Space Complexity - O(1)
   Explanation - Two pointer approach, where we traverse from left till we get a odd number 
                 and then from right till we get an even number and swap them 
                 and continue this, till our left and right pointer are pointing at same value.*/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i =0, j = nums.length-1, temp;
        while(i<j)
        {
            if(nums[i]%2==0)
                i++;
            else if(nums[j]%2==1)
                j--;
            else
            {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }
}
