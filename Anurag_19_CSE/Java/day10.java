//Link For Problem: https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day10 {

    /*
     * Question involves Backtracking.
     * 
     * TC : O(9!)
     * 
     * SC : O(9!)
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Set<List<Integer>> st = new HashSet<>();
        helper(nums, st, new ArrayList<>(), k, n, 0);

        return new ArrayList<>(st);
    }

    static private void helper(int nums[], Set<List<Integer>> st, List<Integer> list, int k, int target, int start) {
        if (target < 0)
            return;

        else if (target == 0 && list.size() == k)
            st.add(new ArrayList<>(list));

        else {
            for (int i = start; i < nums.length; i++) {

                if (target - nums[i] < 0)
                    break;

                list.add(nums[i]);
                helper(nums, st, list, k, target - nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
