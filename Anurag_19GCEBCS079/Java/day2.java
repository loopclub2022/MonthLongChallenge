//Link For Problem: https://leetcode.com/problems/sort-array-by-parity/submissions/

public class day2 {

    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            if ((nums[i] & 1) == 1 && (nums[j] & 1) == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            if ((nums[i] & 1) == 0)
                i += 1;

            if ((nums[j] & 1) == 1)
                j += 1;
        }

        return nums;
    }

    public int[] anotherSolution(int nums[]) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if ((nums[i] & 1) == 0) {

                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

                j += 1;
            }
        }

        return nums;
    }
}
