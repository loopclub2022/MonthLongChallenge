//TC -->O(n^2)
/*  if the value at i index is smaller than the minimum element which is predefined in cpp return true.
//while stack is non empty and element at index i is is greater than element at top of stack store the top element in 'a' and pop it  .

*/
#include<bits/stdc++.h>
using namespace std;                        
class Solution {                          
public:                                  
    bool find132pattern(vector<int>& nums) {
            int a = INT_MIN;
       int n = nums.size();
        stack<int>s;
        for(int i = n-1;i>=0;i--)
        {
            if(nums[i]<a)
                return true;
            else
            {
                while(!s.empty() && nums[i]>s.top())
                {
                    a = s.top();
                    s.pop();
                }
            }
            s.push(nums[i]);
        }
        return false;
    }
};