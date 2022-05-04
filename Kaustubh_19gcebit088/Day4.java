//https://leetcode.com/problems/max-number-of-k-sum-pairs/submissions/


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
            else {i++;j--;result++;}
        return result;
    }

    static int getans(int[] arr, int key){
        int[] idx = new int[arr.length];
        Arrays.fill(idx,0);

        int count = 0;
        int s = 0,e = arr.length-1;
        while(s<e){
            if(idx[s]==0&&idx[e]==0){
                if(arr[s]+arr[e]==key) {
                    idx[s] = 1;
                    idx[e] = 1;
                    count += 1;
                }

                else{
                    s+=1;
                    e-=1;
                }
            }

            if(idx[s]==1){
                s+=1;
            }
            if(idx[e]==1){
                e-=1;
            }

        }
        return count;
    }
}
