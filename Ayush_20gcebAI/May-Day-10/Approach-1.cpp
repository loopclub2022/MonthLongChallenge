// Approach : BackTracking

// Idea : 1. Starting from 1
//        2. "Add" current num to current answer. Then increment num
//        3. If no. of added nums = k and sum != n
//            - "Remove" the last added element from current answer.
//            - Repeat step 2
//        4. If no. of added nums < k
//            - Repeat step 2.

// T.C : O(9^k)
// S.C : Recursion Stack Space => O(k)

class Solution {
    vector<vector<int>> res;
private: 
    void recursion(int k, int n, vector<int> ans, int num)
    {
        if(n == 0 && k == 0)
        {
            res.push_back(ans);
            return;
        }
        
        if((k == 0 && n != 0) || num > 9) return;   
        
        ans.push_back(num);
        recursion(k - 1, n - num, ans, num + 1);
        
        ans.pop_back();
        recursion(k, n, ans, num + 1);
    }
public:
    vector<vector<int>> combinationSum3(int k, int n) 
    {
        vector<int> ans;
        recursion(k, n, ans, 1);
        return res;
    }
};