//Time Complexity:O(N logN)
//Space Complexity:O(1)
//Approach:Two pointer approach. Sort the array. Rest of the code is pretty self explanatory.

class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int first_pointer=0;
        int second_pointer=nums.size()-1;
        int count=0;
        while(first_pointer<second_pointer){
            if(nums[first_pointer]+nums[second_pointer]==k){
                count++;
                first_pointer++;
                second_pointer--;
            }
            else if(nums[first_pointer]+nums[second_pointer]>k){
                second_pointer--;
            }
            else{
                first_pointer++;
            }
        }
        return count;
    }
};
