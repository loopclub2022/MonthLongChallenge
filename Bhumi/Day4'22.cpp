//You are given an integer array nums and an integer k.
//In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
//Return the maximum number of operations you can perform on the array.

//Approach 1 ---> Using Hashmap
//here we are using map to key as well as value --> the idea is if (k-nums[i]) present in map then we'll simply do count++ to store its occurence
//dec its count and if that count is == 0 then we'll remove that element from the map 
//else in case if that element is not present in  map then we'll insert it into map

 // T.c = O(n) --> as we are using loop which runs n times
 //S.c --> O(n) ---> using map
class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
  unordered_map<int,int>mpp;
        int count = 0;
        for(int i =0; i< nums.size(); i++){
            if(mpp.find(k-nums[i]) != mpp.end() ){
             count++;
                mpp[k-nums[i]]--;
                if(mpp[k-nums[i]] == 0){
               mpp.erase(k-nums[i]);
                }
            }
            else{
                mpp[nums[i]]++;
            }
         
        }
         
        return count;
    }
};


 