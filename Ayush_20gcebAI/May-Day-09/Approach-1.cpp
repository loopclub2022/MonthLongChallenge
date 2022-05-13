// Approach : Using Recursion and Hash maps

// Steps : - Map each number with corresponding letters using Hash Map
//         - Make all possible combinations of all letters using recursion
        
// T.C : O(4^n)   { n = number of letters in input string }
// S.C : O(n)     { Recursion Stack Space }

class Solution {
    vector<string> ans;
private:
    void recursion(string digits, unordered_map<char, string> um, int i, string str)
    {
        if(i == digits.length())
        {
            ans.push_back(str);
            return;
        }
        
        for(char ch : um[digits[i]])
        {
            recursion(digits, um, i + 1, str + ch);
        }
    }
    
public:
    vector<string> letterCombinations(string digits)
    {
        if(digits.length() < 1)
        {
            return {};
        }
        
        string str = "";
        
        unordered_map<char, string> um = {{'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
                                          {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
                                         };
        
        recursion(digits, um, 0, str);
        
        return ans;
    }
};