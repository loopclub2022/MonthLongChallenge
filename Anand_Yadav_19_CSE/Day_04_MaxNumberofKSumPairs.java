// link: https://leetcode.com/problems/max-number-of-k-sum-pairs/
// 1679 Leetcode
import java.util.Arrays;

public class Day_04_MaxNumberofKSumPairs {
    public static int worker(int nums[], int k){
        // T: O(N) + O(NlogN) = O(NlogN) S:O(1)
        // approach:
        /*
            sort in asc order
            2 pointers: left & right
            if nums[l] + nums[r] == k , add 1 to count,i-- j++
            if nums[l] + nums[r] >k, means reduce the larger number so j--;
            if                   <k, increase the smaller number therefore i++;
         */
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == k) {
                count++;
                i++;
                j--;
            }
            else if(sum > k) j--;
            else i++;
        }
        return count;

        // T: O(N^2), S: O(1)
        // Brute force
        /*
        int count = 0;
        for(int i=0; i < nums.length; ++i){
            if(nums[i] >= k || nums[i] == -1) continue;
            for(int j=i+1; j < nums.length; ++j){
                if(nums[j] != -1 && nums[i] + nums[j] == k){
                    count++;
                    nums[i] = -1;
                    nums[j] = -1;
                    break;
                }
            }
        }
        return count;
        */
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k = 2;
        System.out.println(worker(arr, k));
    }
}
