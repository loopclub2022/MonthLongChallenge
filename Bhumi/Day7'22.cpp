//Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

//Return true if there is a 132 pattern in nums, otherwise, return false.

//T.C - O(n)
//S.c - O(n)

class Solution {
public:
    bool find132pattern(vector<int>& nums) {
     int sz = nums.size();
        
        //if size is < 3 --> then surely it'll never follow 132 pattern
        if(sz < 3){
            return false;
            
        }
        
        vector<int> vec(sz);
        vec[0] = nums[0];
        for(int i = 1; i< sz; i++){
            vec[i] = min(vec[i-1],nums[i]);  
            // at every index we'll store the minimimum of nums[i]and prev vec[i] so that we can store the min ele at each index
        }
        stack<int>s ;
        for(int i = sz-1; i>=0 ; i--){
            while(!s.empty() && s.top() <= vec[i]) s.pop();
                if(!s.empty() && s.top() < nums[i])
                    return true;
                
                    s.push(nums[i]);
            
        }
        return false;
           }
};

 
  
