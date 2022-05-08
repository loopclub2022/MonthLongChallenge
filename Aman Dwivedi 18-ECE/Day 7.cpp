https://leetcode.com/problems/132-pattern/
Time: O(N)
Space: O(N)

class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int third = INT_MIN;
        int n=nums.size();
        stack<int> st;
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]<third)
                return true;
            while(!st.empty()&&nums[i]>st.top())
            {
                third=st.top();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
    
};
