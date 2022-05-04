//Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
//Return the shortest such subarray and output its length.

//Approach --> Two-Pointers
//Here if we copy our given vector into another vector and then sort that vector then comparison will get easy 
//here we  are using two pointers lo and hi initializing 0 and size-1 respectively . If lo is less than size of vec and value of sorted and unsorted are == then simply do lo ++
// similarly for hi
// if lo < hi (we are using this condition coz in case of sorted array , the val of lo will be higher than val of hi)
// else print 0 coz given vector is already sorted

class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        vector<int>vec;
        int lo = 0, hi = nums.size()-1;
        vec = nums;
        sort(vec.begin(),vec.end());
           
  while(lo < nums.size() && nums[lo] == vec[lo]){
              lo++;
            }
            while(hi > -1 && nums[hi] == vec[hi]){
                hi--;
            }
          if(lo < hi)
          return hi-lo+1;
        else
            return 0;
    }
    
};