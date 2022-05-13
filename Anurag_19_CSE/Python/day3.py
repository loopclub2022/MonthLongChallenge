# Link For Problem: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

"""
Solution Involves
Two Pointer Approach.

TC: O(n) + O(n) = 2O(n) => O(n)
SC: O(1)

"""


class Solution:
    def findUnsortedSubarray(self, nums: list[int]) -> int:
        start: int = -1
        max: int = nums[0]

        for i in range(1, len(nums)):

            if max > nums[i]:
                start = i
            else:
                max = nums[i]

        end: int = 0
        min: int = nums[-1]

        for i in range(len(nums)-2, -1, -1):

            if min < nums[i]:
                end = i
            else:
                min = nums[i]

        return start - end + 1
