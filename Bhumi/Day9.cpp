//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.




//Approach :-
//as we can see if our k > n then it'll not possible to make any such pair . secondly in prblm we can't use the element more than once 
//so ,here we'll use backtacking logic ...
// eg -- k = 3, n = 7 first we'll start if k == 0 means we found the size as given, then with the size which is 3 if such pair having sum equal to n then we'll store that in ans vector
// initially k = 3 so it'll the just push the count in vec and inc its count by one call the function again and dec k by 1 means we've one value which we've stored in vector vec
// once k = 0 , means we've 3 values in vec vec and if the sum of those 3 values == n then we'll psush that in ans vector
//once first recursion call completed we pop out the element from the vec and as we know p=our k = 0, we just inc the count so that element will not be repeated

//T.C - O(n)
//S.C - O(n) coz we're using vector extra space to store the elem


class Solution {
public:
    vector<vector<int>>ans;
     int total(vector<int> &vec){
        int res = 0;
        for(auto it : vec){
            res += it;
        }
         return res;
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        if(k > n) return {};
        vector<int>vec;
         validCombinations(k,n,vec,1);
        return ans;
    }
    void validCombinations(int k, int n, vector<int>&vec,int count){
        if( k == 0){
            if(total(vec) == n){
                 ans.push_back(vec);
            } 
               
        }
        if(count > 9) return ;
        vec.push_back(count);
        validCombinations(k-1,n,vec,count+1);
        vec.pop_back();
        validCombinations(k,n,vec,count+1);
        
    }
    
    
    
};