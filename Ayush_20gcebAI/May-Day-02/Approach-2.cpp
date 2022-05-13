// Approach 2 : Using two Pointers (Optimised to have least number of swaps) :
// Idea : 
// Keep Two pointers :
// 1: First pointer points to current index.
// 2: Swap ith and jth element only If j pointer points to an odd number.

// T.C : O(n) (n = number of elements in give array)
// S.C : O(1)

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) 
    {
        int i = 0, j = 0;
        
        // Traverse through the array
        while(i < nums.size())
        {   
            if(!(nums[j] & 1))
            {
                ++j;
            }
            else if(!(nums[i] & 1))
            {
                std::swap(nums[i], nums[j]);
                ++j;
            }
            
            ++i;
        }
        
        // At each point of time the program satisfies that each element at index less than 'j' is even.
        
        return nums;
    }
};