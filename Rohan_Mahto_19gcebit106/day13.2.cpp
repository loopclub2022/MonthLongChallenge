class Solution {
public:
    int findindex(int low,int high,int target,vector<int>& nums)
    {
        int tar=-1;
        
        while(low<=high)
        {
            int mid = low + (high -low) / 2;
            if( mid>0 and nums[mid-1]<target and target<=nums[mid])
            {
                tar= mid;
                break;
            }
            else if(mid==0 and nums[mid]<target and target<nums[mid+1])
            {
                
                tar=mid+1;
                break;
            }
            else if(target<nums[mid])
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
            
        }
        return tar;
    }
    int searchInsert(vector<int>& nums, int target) {
        if(target<=nums[0])
        {
            return 0;
        }
        else if(target>nums[nums.size()-1])
        {
            return nums.size();
        }
        else if(target==nums[nums.size()-1])
        {
            return nums.size()-1;
        }
        return findindex(0,nums.size()-1,target,nums);
    }
};