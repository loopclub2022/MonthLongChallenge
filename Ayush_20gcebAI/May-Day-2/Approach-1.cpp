// Approach 1 : Using two Pointers :
// Idea : 
// Keep Two pointers :
// 1: First pointer points to current index.
// 2: Second pointer points to the index offirst odd element in the current array.

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
            // If current number is even, swap it with the first odd element in the array.
            
            if(nums[i] % 2 == 0)
            {
                std::swap(nums[i], nums[j]);
                ++j;
            }
            
            ++i;
        }
        
        return nums;
    }
};