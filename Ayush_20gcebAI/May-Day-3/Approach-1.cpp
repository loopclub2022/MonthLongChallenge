// Approach : Using Two Pointers

// Steps : 
// 1 - Find the first and last index where the sort property is violated.
// 2 - Find the min and max numbers between the first index and last index.
// 3 - keep incrementing count1 till : min < arr[prev]      (prev is indexes before first)
// 4 - keep incrementing count2 till : max > arr[next]  (next is indexes after last)
// 5 - ans = (last - first) + count1 + count2 + 1

// T.C : 4*O(n)
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
        int prev = first - 1, next = last + 1;
        
        int minm = nums[first], maxm = nums[first];
        ++first;
        
        while(first <= last)
        {
            if(nums[first] < minm) minm = nums[first];
            if(nums[first] > maxm) maxm = nums[first];
            ++first;
        }
        
        while(prev != -1 && minm < nums[prev])
        {
            ++ans;
            --prev;
        }
        
        while(next != nums.size() && maxm > nums[next])
        {
            ++ans;
            ++next;
        }
        
        return ans;
    }
};