//Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

//Return any array that satisfies this condition.

 


class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        vector<int>vec;
        vector<int>vec2;
        for(int i=0; i<nums.size(); i++){
        if(nums[i]%2 == 0){
            vec.push_back(nums[i]);
        }
        else{
            vec2.push_back(nums[i]);
        }
        }
        
        vec2.insert(vec2.begin(),vec.begin(),vec.end());
        return vec2;
    }
};