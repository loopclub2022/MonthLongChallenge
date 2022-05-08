//Link For Problem: https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.Arrays;
import java.util.HashMap;

public class day4 {

    /*
     * Put the array elements
     * in a map and keep the frequency
     * count.
     * 
     * Check if (k-i) exists
     * in the map or not.
     * 
     * TC: O(n) + O(n) = 2O(n) => O(n)
     * SC: O(n)
     */

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : nums) {
            if (i >= k)
                continue;

            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (int i : nums) {
            if (i >= k)
                continue;

            int diff = k - i;

            if (diff == i && hm.containsKey(diff)) {
                count += Math.floor(hm.get(diff) / 2);
                hm.remove(diff);
            }

            else if (hm.containsKey(diff) && hm.containsKey(i)) {
                count += Math.min(hm.get(i), hm.get(diff));
                hm.remove(diff);
                hm.remove(i);
            }
        }

        return count;
    }

    /*
     * Simply Sort the
     * Array.
     * 
     * Use Two Pointer Approach
     * to check if the sum is
     * equal to k.
     * 
     * TC: O(nlogn) + O(n) => O(nlogn)
     * SC: O(1)
     */

    public int twoPointer(int nums[], int k) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        int count = 0;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == k) {
                count += 1;
                i += 1;
                j -= 1;
            }

            else if (sum < k)
                i += 1;

            else
                j -= 1;
        }

        return count;
    }
}
