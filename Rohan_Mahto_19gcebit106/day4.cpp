/* approach - used map for checking the pairs and remove the pairs which are equal to k and keeping the count of removed pairs.
Time Complexity-O(n)+O(log n)
space-O(n)*/
class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        unordered_map<int,int>mp;
        int count=0;
        for(int i=0;i<nums.size();i++)
        {
            if(mp.find(k-nums[i])!=mp.end())
            {
                if(mp[k-nums[i]]==1)
                {
                    mp.erase(k-nums[i]);
                }
                else
                {
                    mp[k-nums[i]]--;
                }
                count++;
            }
            else
            {
                mp[nums[i]]++;
            }
        }
        return count;
    }
};