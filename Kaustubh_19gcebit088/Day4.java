//https://leetcode.com/problems/max-number-of-k-sum-pairs/submissions/

// time complexity = O(n)
// space complexity = O(1)

// approach:
// first sort the given array
// then apply binary search kind of approach
//  maintain a result counter, everytime nums[i]+nums[j]==k:
//  add 1 to it, and move st pointer one step ahead, and end pointer one step back
// because we are to remove these elements from the arr, 
// so removing them from the search space using the start and end pointers is one way to it.






import java.util.Arrays;

public class Day4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(maxOperations(arr,5));
    }

    static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0, i =0, j= nums.length -1;
        while(i<j)
            if(nums[i]+nums[j] > k) j--;
            else if(nums[i]+nums[j] < k) i++;
            else {
                i++;
                j--;
                result++;
            }
        return result;
    }


}
