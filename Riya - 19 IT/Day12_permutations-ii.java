/* Question - https://leetcode.com/problems/permutations-ii/submissions/

   Time Complexity - O(N!)
   Space Complexity - O(N)
                       N is the length of nums array
   Approach - Simple Backtracking, counting all the possible permutation of the given array,
              Further, while we add new Permutation it is checked if it already exist,
              if not only then it is added.
*/

class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i <nums.length;i++)
        {
            list.add(nums[i]);
        }
        allcombi(list, 0);
        return permutations;
    }
    public void allcombi(List<Integer> arr, int k)
    {
        for(int i =k;i<arr.size();i++)
        {
            Collections.swap(arr,i,k);
            allcombi(arr,k+1);
            Collections.swap(arr,k,i);
        }
        if(k==arr.size()-1 && !permutations.contains(arr))
        {
            permutations.add(new ArrayList(arr) );
            return;
        }
    }
}
