//Link For Problem: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

import java.util.Arrays;

public class day3 {

    /*
     * First Solution Involves Sorting the
     * input array.
     * 
     * TC: O(nlogn)
     * SC: O(n)
     */

    public int findUnsortedSubarray(int[] nums) {
        int arr[] = nums.clone();
        Arrays.sort(arr);

        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (arr[i] == nums[i])
                i += 1;

            if (arr[j] == nums[j])
                j -= 1;

            if (arr[i] != nums[i] && arr[j] != nums[j])
                break;
        }

        return (i == j ? 0 : j - i + 1);
    }

    /*
     * Second Solution Involves Two
     * Pointer Approach.
     * TC: O(n) + O(n) = 2O(n) => O(n)
     * SC: O(1)
     */

    public int twoPointer(int nums[]) {
        int start = -1, max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (max > nums[i])
                start = i;
            else
                max = nums[i];
        }

        int end = 0, min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {

            if (min < nums[i])
                end = i;
            else
                min = nums[i];
        }

        return start - end + 1;
    }
}
