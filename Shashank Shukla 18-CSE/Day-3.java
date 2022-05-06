// Time: O(N), Space: O(N)
//two pointers approach using stack. No sorting required

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i1=nums.length, i2=-1;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] >nums[i]){
                i1 = Math.min(st.pop(), i1);
            }
            st.push(i);
        } st.clear();
        for(int i = nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                i2=Math.max(i2, st.pop());
            }
            st.push(i);
        }
        return i2 - i1 >0 ? i2-i1+1: 0;
    }
}
