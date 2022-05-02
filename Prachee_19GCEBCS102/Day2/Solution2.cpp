class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int i,k; int j=0;
        array<int,5000> temp{0};
        for(i=0; i<nums.size(); i++){
            if(nums[i]%2==0){
                temp[j]=nums[i];
                j++;
            }
        }
        for(k=0; k<nums.size(); k++){
            if(nums[k]%2!=0){
                temp[j]=nums[k];
                j++;
            }
        }
        for(i=0; i<nums.size(); i++){
            nums[i]= temp[i];
        }
        return nums;
    }
};
