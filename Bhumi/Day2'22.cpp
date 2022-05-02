//Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

//Return any array that satisfies this condition.

 

//Approach 1 ---> Using vectors
// here approach is creating 2 vectors in which vec will store the even elements and vec2 will store the add elements
//and at last we'll concatenate the element of vec2 into vec
// Time Complexity -- O(n) (as we're using for-loop)
//space complexity -- O(n) [take extra space while creating 2 vectors]
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


//Approach -2 ---> Two pointers approach
// here , we take lo and hi where lo pointing to the starting index and hi is pointing to last index 
//here we make changes in nums vector hence we save the memory
// TC- O(n)
//Sc- O(1) as we're not using any extra space
class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
    int lo = 0, hi = nums.size()-1;
        while(lo < hi){
            if(nums[lo]%2 != 0 && nums[hi]%2 == 0 ){
                swap(nums[lo],nums[hi]);
                lo++,hi--;
            }
            else if(nums[lo]%2 != 0 && nums[hi]%2 != 0){
                hi--;
            }
            else if(nums[lo]%2 == 0 && nums[hi]%2 != 0){
                lo++,hi--;
            }
            else{
                lo++;
            }
        }
        return nums;
    }
};