Approach : Using Three Pointers (TLE)

Steps : Take any three indexes and check if the property following is true: 
        nums[i] < nums[k] && nums[k] < nums[j]
        Repeat this process for all elements.
        

T.C : O(n3)
S.C : O(1)

class Solution {
public:
    bool find132pattern(vector<int>& nums) 
    {
        int n = nums.size();
        
        for(int i = 0; i < n; ++i)
        {
            for(int j = i + 1; j < n; ++j)
            {
                for(int k = j + 1; k < n; ++k)
                {
                    if(nums[i] < nums[k] && nums[k] < nums[j])
                        return true;
                }
            }
        }
        
        return false;
    }
};