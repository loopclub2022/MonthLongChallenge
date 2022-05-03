/*Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Time Complexity-O(n)
space Complexity-O(1)
*/

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int i=0;
        int j=0;
        
        while(j<nums.size())
        {
            if(nums[j]%2==0)
            {
                swap(nums[i],nums[j]);
                {
                    i++;
                    j++;
                }
            }
            else
            {
                j++;
            }
        }
        return nums;
        
    }
};
