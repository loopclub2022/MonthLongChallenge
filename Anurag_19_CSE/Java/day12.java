import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class day12 {

    /*
     * Solution involves Backtracking.
     * 
     * For Unique Elements, Maintain a Set.
     * 
     * Rest of the solution is self-explanatory.
     * 
     * TC : O(n!)
     * 
     * SC : O(n)
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return ans;

        calculate(ans, nums, 0);

        return ans;
    }

    private void calculate(List<List<Integer>> ans, int nums[], int index) {
        if (index == nums.length) {
            List<Integer> al = new ArrayList<>();

            for (int i : nums)
                al.add(i);

            ans.add(al);
            return;
        }

        HashSet<Integer> hs = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (hs.add(nums[i])) {
                swap(nums, index, i);
                calculate(ans, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * This solution involves a Map.
     * 
     * Maintain a frequency map of all the unique elements.
     * 
     * Rest is standard Backtracking.
     * 
     * TC: O(n!)
     * 
     * SC: O(n)
     * 
     */

    public List<List<Integer>> anotherSolution(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return ans;

        List<Integer> perm = new ArrayList<>();

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums)
            hm.put(i, hm.getOrDefault(i, 0) + 1);

        permute(ans, perm, hm, nums, 0);

        return ans;
    }

    private void permute(List<List<Integer>> ans, List<Integer> perm, HashMap<Integer, Integer> hm, int nums[],
            int count) {
        if (count == nums.length) {
            List<Integer> temp = new ArrayList<>(perm);
            ans.add(temp);
            return;
        }

        for (int i : hm.keySet()) {

            if (hm.get(i) > 0) {
                hm.put(i, hm.get(i) - 1);
                perm.add(i);

                permute(ans, perm, hm, nums, count + 1);

                hm.put(i, hm.get(i) + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
