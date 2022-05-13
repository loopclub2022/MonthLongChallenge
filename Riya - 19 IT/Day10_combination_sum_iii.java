/* Question - https://leetcode.com/problems/combination-sum-iii/
   
   Time Complexity - O(9^k)
   Space Complexity - O(k)
   Approach - Backtracking is used, where once every single digit from 1 to 9 is checked weather included or not would result in sum n or not.*/

class Solution {
    
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        combination(k,n,1);
       return output; 
    }
    
    public void combination(int k, int n, int pos)
    {
        if(k==0 && n==0)
        {
            output.add(new ArrayList<>(list));
        }
        else
        {
            for(int i = pos;i<=9;)
            {
                list.add(i);
                combination(k-1,n-i,++i);
                list.remove(list.size()-1);
            }
        }
    }
}
