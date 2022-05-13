// Approach : Using BackTracking

// Idea : 

// - Here I have assumed "a, e, i, o, u" as an array having indices 0, 1, 2, 3, 4.

// - If I add current vowel => increment k
// - If k == n => This is one answer
// - If curr reaches five => return ecause we have only 5 vowels.
// - On Backtracking increment current vowel and let k as it is (showing that we are not adding current element ).
// - Repeat step 1
    
// T.C : Order of in average case n^4
// S.C : Recursion Stack Space => O(n)


class Solution {
public:    
    void utilCount(int n, int curr, int k, int& ans)
    {    
        if(k == n)
        {
            ++ans;
            return;
        }
        
        if(curr == 5)
            return;
        
        utilCount(n, curr, k + 1, ans);
        utilCount(n, curr + 1, k, ans);
    }
    
    int countVowelStrings(int n) 
    {
        int ans = 0;
        utilCount(n, 0, 0, ans);
        return ans;
    }
};