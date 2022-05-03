// Approach : Using Two Pointers

// Steps : 
// 1 - Find the first and last index where the sort property is violated.
// 2 - Sort the array from first to last index
// 3 - keep incrementing count1 till : arr[first] < arr[prev]  (prev is indexes before first)
// 4 - keep incrementing count2 till : arr[last] > arr[next]   (next is indexes after last)
// 5 - ans = (last - first) + count1 + count2 + 1

// T.C : 4*O(n) + O(nlogn) in  worst case.
// S.C : O(1)

class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) 
    {
        if(nums.size() == 1) return 0;
        
        int first = -1, last = -1, l = 0, r = nums.size() - 1, ans = 1;
        
        while((l <= r) && (first == -1 || last == -1))
        {
            if(first == -1 && nums[l] > nums[l + 1])
                first = l;
            
            if(last == -1 && nums[r] < nums[r - 1])
                last = r;
            
            if(first == -1) ++l;
            if(last == -1) --r;
        }
        
        if(first == -1) return 0;
        
        ans += last - first;
        
        sort(nums.begin() + first, nums.begin() + last + 1);
        
        int prev = first - 1, next = last + 1;
        
        while(prev != -1 && nums[first] < nums[prev])
        {
            ++ans;
            --prev;
        }
        
        while(next != nums.size() && nums[last] > nums[next])
        {
            ++ans;
            ++next;
        }
        
        return ans;
    }
};