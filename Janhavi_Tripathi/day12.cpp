#include<bits/stdc++.h>
using namespace std;
class Solution {
public:

//create a set which will store my quique permutations .because set stores uique elements only

    vector<vector<int>> permuteUnique(vector<int>& nums) {
         set<vector<int>> st;
         //we will store the given combination in another variable to compare it afterwards.
        vector<int> temp = nums;
        
        //run loop to store quique combinations until again loop runs from start. 
         //print the combos .
        do
        {
            next_permutation(temp.begin(), temp.end());
            st.insert(temp);
        } while (temp != nums);
        vector<vector<int>> ans;
        for (auto it: st)
            ans.push_back(it);
        return ans;
    }
};