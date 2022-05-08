//Link For Problem : https://leetcode.com/problems/132-pattern/

import java.util.Stack;

public class day7 {

    /*
     * First Solution is Pretty Straight Forward.
     * 
     * Instead of running three loops, just maintain a min variable.
     * 
     * Run two nested loops over the array and
     * check for the conditions.
     * 
     * TC : O(n^2)
     * 
     * SC : O(1)
     */

    public boolean find132pattern(int[] nums) {
        int min = nums[0];

        for (int j = 0; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {

                if (nums[k] > min && nums[j] > nums[k])
                    return true;

                min = Math.min(min, nums[j]);
            }
        }

        return false;
    }

    /*
     * For Optimized Approach,
     * Maintain a Monotonically Decreasing Stack.
     * 
     * Push Only the Greater Element ('3rd element' in '132') in the stack.
     * 
     * If top of the stack is less than the current element
     * then pop the top of the stack.
     * 
     * Check if the current element ('1st element' in '132') is less than the
     * maintained
     * third variable which keeps track of the '2nd element' in '132'.
     * 
     * If yes, then return true.
     * 
     * Refer : https://www.youtube.com/watch?v=q5ANAl8Z458
     * 
     * TC: O(n)
     * 
     * SC: O(n)
     * 
     */

    public boolean optimizedUsingStack(int nums[]) {
        Stack<Integer> st = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third)
                return true;

            while (!st.isEmpty() && st.peek() < nums[i])
                third = st.pop();

            st.push(nums[i]);
        }

        return false;
    }
}
