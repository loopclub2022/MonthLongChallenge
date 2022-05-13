class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>>finals;
       sort(nums.begin(),nums.end());
        finals.push_back(nums);
        while(true)
        {
            int i=nums.size()-1;
            int p;
            while(i>0)
            {
                if(nums[i]<=nums[i-1])
                {
                    i--;
                }
                else
                {
                    p=i-1;
                    break;
                }
            }
            if(i==0)
            {
                break;
            }
            int mini=INT_MAX;
            int a;
            for(int z=p+1;z<nums.size();z++)
            {
                if(nums[z]>nums[p] and nums[z]<mini)
                {
                    a=z;
                    mini=nums[z];
                }
            }
            swap(nums[p],nums[a]);
            sort(nums.begin()+p+1,nums.end());
            finals.push_back(nums);
                
        }
        return finals;
        
    }
};