//Did it in O(N) XD
//Space Complexity:O(1)
//Approach:If the array is sorted, return 0. Else, check for the minimum and maximum element in that part from the array from where it starts getting unsorted.
// Then find the position where they should be in the sorted array. The difference of their positions gives the answer.
class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        bool sorted=true;
        int sz=nums.size();
        for(int i=0;i<sz-1;i++){
            if(nums[i]>nums[i+1]){
                sorted=false;
                break;
            }
        }
        if(sorted){
            return 0;
        }
        else{
            //Step 1:Find the min and max element from the part where the array starts becoming unsorted
            bool has_been_unsorted=false;
            int min_num=INT_MAX;
            for(int i=1;i<sz;i++){
                if(nums[i]<nums[i-1]){
                    has_been_unsorted=true;
                }
                if(has_been_unsorted){
                    min_num=min(nums[i],min_num);
                }
            }
            has_been_unsorted=false;
            int max_num=INT_MIN;
            for(int i=sz-2;i>=0;i--){
                if(nums[i]>nums[i+1]){
                    has_been_unsorted=true;
                }
                if(has_been_unsorted){
                    max_num=max(nums[i],max_num);
                }
            }
            //cout<<max_num;
            //Step 2:Find the rightful position of the min and the max elements in the array
            int min_pos,max_pos;
            for(min_pos=0;min_pos<sz;min_pos++){
                if(nums[min_pos]>min_num){
                    break;
                }
            }
            for(max_pos=sz-1;max_pos>=0;max_pos--){
                if(nums[max_pos]<max_num){
                    break;
                }
            }
            //cout<<max_pos<<" "<<min_pos;
            return max_pos-min_pos+1;
        }
    }
};
