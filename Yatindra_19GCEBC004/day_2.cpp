class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int sz=nums.size();
        vector <int> ans;
        ans.reserve(sz);
        int first_index=0;
        int last_index=sz-1;
        for(int i=0;i<sz;i++){
            ans.push_back(0);
        }
        for(int i=0;i<sz;i++){
            if(nums[i]%2==0){
                ans[first_index++]=nums[i];
            }
            else{
                ans[last_index--]=nums[i];
            }
        }
        return ans;
    }
};
