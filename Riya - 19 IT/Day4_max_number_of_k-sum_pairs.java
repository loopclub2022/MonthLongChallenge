/* Question - https://leetcode.com/problems/max-number-of-k-sum-pairs/submissions/

   Time Complexity - O(n)
   Space Complexity - O(n)
   Explanation - Traversing through the array storing that element with the count
                 and finding the remaining sum(k-element) in the hashmap
                 after the pair is found, the elements count is decreased
                 and overall count of pairs is incremented.
*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(map.containsKey(k-nums[i]))
            {
                if(map.get(k-nums[i])==1)
                    map.remove(k-nums[i]);
                else
                    map.put(k -nums[i], map.get(k -nums[i])-1);
                count++;
            }
            else
            {
                if(map.containsKey(nums[i]))
                    map.put(nums[i],map.get(nums[i])+1);
                else
                    map.put(nums[i],1);
            }
        }
        return count;
    }
}
