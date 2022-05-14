#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
          //TC=O(n^2)
          
          
          for(int i=0;i<nums.size();i++)
     {
         int curr= nums[i];
         for(int j=i+1;j<nums.size();j++)
         {
             if(target-curr==nums[j])
             {
                 return {i, j};
             }
         }
     }
     return {-1,-1};
    }
};