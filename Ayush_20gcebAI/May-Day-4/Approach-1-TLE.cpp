/*

Approach : Using Nested Loops (TLE)

Steps : 
1 : For each element in the array, check for other element pairing with whom the sum becomes k.
2 : This can be done by using one loop to fix one number and checking for the second number in the remaining array.
3 : If pair exist then we have to remove current elements to remove duplicates. Thus make both of them equal to zero. If in future zero comes, we will not count it.

T.C : O(n^2)
S.C : O(1)

*/


class Solution {
public:
    int maxOperations(vector<int>& nums, int k) 
    {
        int count = 0;
        
        for(int i = 0; i < nums.size() - 1; ++i)
        {
            for(int j = i + 1; j < nums.size(); j++)
            {
                if(nums[i] != 0 && nums[j] != 0 && nums[i] + nums[j] == k)
                {
                    ++count;
                    nums[i] = 0;
                    nums[j] = 0;
                }
            }
        }
                  
        return count;
    }
};