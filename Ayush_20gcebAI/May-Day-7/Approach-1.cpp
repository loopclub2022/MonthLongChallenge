Approach : Using Two Pointers :

Steps : Fix the index j
        Find the min number in [0, j]
        If a number exist in [j + 1, n] such that it is greater than min and smaller than num[j] => return true
        Repeat these steps for all index j.

T.C : O(n2)
S.C : O(1)

class Solution {
public:
    bool find132pattern(vector<int>& nums) 
    {
        int n = nums.size() , minI = nums[0];
        
        for(int j = 1; j < n - 1; ++j)
        {
            minI = min(minI, nums[j]);
            
            if(minI == nums[j]) continue;
            
            for(int k = n - 1; k > j; --k)
            {
                if(nums[k] > minI && nums[k] < nums[j])
                    return true;
            }
        }
        
        return false;
    }
};