// link: https://leetcode.com/problems/sort-array-by-parity/
// 905 leetcode
public class Day_02_SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {

        //Time: O(N) Space:O(1)

        int len = nums.length-1;
        for(int i=0; i<len; i++){
            if(nums[i]%2 != 0){
                int tmp = nums[i];
                nums[i] = nums[len];
                nums[len] = tmp;
                len--;
                i--;
            }
        }

        /*
        // Time:O(N^2) Space:O(1)
        // pointer approach
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            while(i<j && nums[i]%2 == 0){
                i++;
            }
            while(i<j && nums[j]%2 != 0){
                --j;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }*/
        return nums;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,0,9,3};
        sortArrayByParity(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
