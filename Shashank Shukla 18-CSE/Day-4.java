// O(N), O(N)
// using HashMap, extension of two sum, here just need to count the pairs
class Solution {
    public int maxOperations(int[] nums, int k) {
        int res=0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
             if(nums[i] < k){
                if(m.containsKey(k - nums[i])&&m.get(k-nums[i])>0){

                   // System.out.println(m.remove(nums[i]));

                    // m.remove(k-nums[i]);
                    res++;
                    m.put(k-nums[i],m.get(k-nums[i])-1);
                }   else  m.put(nums[i],m.getOrDefault(nums[i], 0)+1);
            } 
        }
        // System.out.println(m);
        return res;
    }
}
