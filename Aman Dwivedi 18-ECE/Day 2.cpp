Time: O(N)
Space: O(N)

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        vector<int> odd,even;
        for(auto i:nums)
        {
            if(i&1)
                odd.push_back(i);
            else
                even.push_back(i);
        }
        for(auto i:odd)
            even.push_back(i);
        return even;  
    }
};
