// Approach : Sort the given array :

// Steps :
// 1 - Copy original array in temp array
// 2 - Sort the temp array
// 3 - Find the minimum index where nums[i] != temp[i]
// 4 - Find the maximum index where nums[i] != temp[i]
// 5 - If there is no such index ; return 0
// 6 - Otherwise return the number of elements b/w min and max index

// T.C : O(nlogn) + O(n) + O(n) => O(nlogn)
// S.C : O(n) + Space Taken by Inbuilt Srting Algo => O(n)


class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) 
    {
        int n = nums.size();
        
        vector<int> sortedNums = nums;
        sort(sortedNums.begin(), sortedNums.end());

        int i = 0, j = n - 1;
        
        while(i < n)
        {
            if(nums[i] != sortedNums[i])
                break;
            
            ++i;
        }
        
        while(j > -1)
        {
            if(nums[j] != sortedNums[j])
                break;
            
            --j;
        }
        
        if(i == n || j == -1) return 0;
        
        return (j - i + 1);
    }
};