/* Question - https://leetcode.com/problems/132-pattern/

   Time Complexity - O()
   Space Complexity - O()
   Approach - We traverse the atck from the back, to find the lowest number while maintaining the value of highest and second highest number
              The 3 in 132 pattern is maintained in the stack, while the second highest i.e 2 is stored in variable v
              And while the array is traversed from last to first element, whenever we get a number i.e less than v
              Then we probably get number that is less than both the v and the stack number
              Thus, the 132 pattern is found.
*/

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        
        int second_highest = Integer.MIN_VALUE;
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] < second_highest) 
                return true;
            while(!s.isEmpty() && s.peek() < nums[i]) 
                second_highest = s.pop();
            s.push(nums[i]);
        }
        return false;
    }
}
