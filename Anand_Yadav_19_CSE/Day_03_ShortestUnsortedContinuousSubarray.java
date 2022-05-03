//Link : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// 581 Leetcode
public class Day_03_ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int end = -1, max = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] < max)
                end = i;
            else
                max = nums[i];
        }
        int start = 0, min = nums[n - 1];
        for (int i = n - 2; i >= 0; i--){
            if (nums[i] > min)
                start = i;
            else
                min = nums[i];
        }
        return end - start + 1;
    }
}
        //Buggy
        // T: O(N) S: O(1)
//        public static int findUnsortedSubarray(int[] nums) {
//        int slow = 0;
//        int fast = 1;
//        if(nums.length == 1) return 0;
//        while(fast < nums.length){
//            if(nums[fast-1] >= nums[fast]){
//                slow = fast;
//                break;
//            }
//            fast++;
//        }
//        int lastIndex = slow;
//        int j = nums.length-1;
//        lastIndex = j;
//        while(j > slow){
//            if(nums[j] > nums[slow+1] && nums[j] <= nums[j-1]){
//                lastIndex = j;
//            }
//            else{
//                break;
//            }
//            j--;
//        }
//        return (lastIndex-slow);
//    }
    public static void main(String[] args) {
        int nums[] = new int[]{2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums)); //5
        int m[] = new int[]{1,3,2,2,2};
        System.out.println(findUnsortedSubarray(m));  //4
        m = new int[]{1,3,2,3,3};
        System.out.println(findUnsortedSubarray(m));  //2
    }
}
