//day-2 code two pointers approach 
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start=0, end = nums.length-1;
        while(start < end){
            if(nums[start] % 2 != 0){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
            } else start++;
        }
        return nums;
    }
}
