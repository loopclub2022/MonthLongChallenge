// Approach : TrackingBack

// Idea : - Sort the array
//        - keep adding all nums which are not present in current subset Using BackTracking Method
//        - If subset size = given array size : Add it to answer
//        - Just added one condition : if current num = prev num => Skip that step
      
// T.C : O(n!*n)
// S.C : O(n)

class Solution {
private:
    void recursion(vector<int>& nums, vector<vector<int>>& ans, vector<int> temp)
    {
        if(temp.size() == nums.size())
        {
            ans.push_back(temp);
            return;
        }
        
        for(int i = 0; i < nums.size(); i++)
        {
           if(nums[i] != 11)    // 11 is used since range of numbers in nums is <= 10
           {
               if(i > 0 && nums[i] == nums[i - 1]) continue;
               
               int t = nums[i];
               nums[i] = 11;
               temp.push_back(t);
               recursion(nums, ans, temp);
            
               nums[i] = t;
               temp.pop_back();
           }
        }
        
    }
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) 
    {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        recursion(nums, ans, {});
        return ans;
    }
};