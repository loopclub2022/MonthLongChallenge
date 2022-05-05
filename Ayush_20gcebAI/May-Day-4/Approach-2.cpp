/*

Approach : Using Two Pointers :

Intution : We have to find number of operations which can be performed
      i.e  The number of distinct pairs whose sum equals k.
           We can do this by sorting the array and using two pointers to find if sum of elements equals k.
           
Steps : 
1 : Sort the array
2 : Take two pointers : l -> pointing to first index and r-> pointing to last index.
3 : if nums[l] + nums[r] < k => We have to increase the sum to reach k thus move 'l' to right side of the sorted array.
4 : if nums[l] + nums[r] > k => We have to decrease the sum to reack k thus move 'r' to left side of the sorted array.
5 : if nums[i] + nums[k] = k => We have found a pair thus increment count and move 'l' to right and 'r' to left to remove them from current process.
6 : Finally return the count.


T.C : O(nlogn) + O(n) => O(nlogn)
S.C : Space taken by Inbuilt sorting algo : O(n) in worst case.

*/

class Solution {
public:
    int maxOperations(vector<int>& nums, int k) 
    {
        sort(nums.begin(), nums.end());
        
        int l = 0, r = nums.size() - 1, count = 0;
        
        while(l < r)
        {
            if(nums[l] + nums[r] < k)
                ++l;
            else if(nums[l] + nums[r] > k)
                --r;
            else
            {
                ++count;
                ++l;
                --r;
            }
        }
        
        return count;
    }
};