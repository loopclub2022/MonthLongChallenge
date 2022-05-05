/*

Approach : Using Hash Maps

Steps : 
1 : Traverse through the array
2 : For each element , check if there exist an element in the map pairing with which the current element becomes equal to k.
3 : If yes => increment count and delete that element from map to prevent duplicates.
4 : If not => add current element to the map.
5 : Finally return count.

T.C : O(n)
S.C : O(n)

*/


class Solution {
public:
    int maxOperations(vector<int>& nums, int k) 
    {
        int count = 0;
        unordered_map<int, int> um;
        
        for(int i = 0; i < nums.size(); ++i)
        {
            if(um[k - nums[i]] > 0)
            {
                ++count;
                --um[k - nums[i]];
            }
            else
            {
                ++um[nums[i]];
            }
        }
                  
        return count;
    }
};