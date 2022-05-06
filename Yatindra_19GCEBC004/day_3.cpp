//Time Complexity:O(n^2) (Almost did it in O(n) :p)
//Space Complexity:O(n)
//Approach:Sorted the given vector, and found the leftmost and rightmost non-matching elements. Their difference is returned.
class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int first_unsorted_position=-1;
        int last_unsorted_position=-1;
        bool sorted=true;
        int sz=nums.size();
        for(int i=0;i<sz-1;i++){
            if(nums[i]>nums[i+1]){
            sorted=false;
            if(!sorted&&first_unsorted_position==-1){
                first_unsorted_position=i;
                last_unsorted_position=i+1;
                for(int j=first_unsorted_position-1;j>=0;j--){
                    if(nums[j]>nums[last_unsorted_position]){
                        first_unsorted_position=j;
                    }
                    else{
                        break;
                    }
                }
                last_unsorted_position=i+1;
            }
            else if(!sorted && first_unsorted_position!=-1){
                last_unsorted_position=i+1;
            }
        }
        }
        if(sorted){
            return 0;
        }
        else{
            //cout<<last_unsorted_position<<" "<<first_unsorted_position;
            if(nums[sz-1]<nums[first_unsorted_position]){
            last_unsorted_position=sz-1;
        }
            return last_unsorted_position-first_unsorted_position+1;
        }
    }
};
