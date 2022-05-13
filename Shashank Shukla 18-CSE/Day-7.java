/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int last = Integer.MIN_VALUE;
        for(int i= n-1; i>=0; i--){
            if(last>nums[i]){
                return true;
            }
            while(!st.isEmpty() && st.peek()<nums[i])
                last = st.pop();
            st.push(nums[i]);
        }
        return false;
    }
}
