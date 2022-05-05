# Link For Problem: https://leetcode.com/problems/max-number-of-k-sum-pairs/

from collections import Counter
from math import floor


class Solution:

    """
      Put the array elements
      in a map and keep the frequency
      count.

      Check if (k-i) exists
      in the map or not.

      TC: O(n) + O(n) = 2O(n) => O(n)
      SC: O(n)

    """

    def maxOperations(self, nums: list[int], k: int) -> int:
        map = {}

        for i in nums:
            if i >= k:
                continue

            if i in map:
                map[i] += 1
            else:
                map[i] = 1

        count: int = 0

        for i in nums:
            if i >= k:
                continue

            diff: int = k-i

            if diff == i and diff in map:
                count += floor(map[diff]/2)
                map.pop(diff)

            elif i in map and diff in map:
                count += min(map[i], map[diff])
                map.pop(i)
                map.pop(diff)

        return count

    def another_solution(self, nums: list[int], k: int) -> int:
        map = Counter(nums)

        count: int = 0

        for i in nums:
            if i >= k:
                continue

            diff: int = k-i

            if diff == i and diff in map:
                count += floor(map[diff]/2)
                map.pop(diff)

            elif i in map and diff in map:
                count += min(map[i], map[diff])
                map.pop(i)
                map.pop(diff)

        return count

    """
     Simply Sort the
     Array.
      
     Use Two Pointer Approach
     to check if the sum is
     equal to k.
      
     TC: O(nlogn) + O(n) => O(nlogn)
     SC: O(1)

    """

    def two_pointer(self, nums: list[int], k: int) -> int:
        nums.sort()

        i, j = 0, len(nums)-1
        count: int = 0

        while(i < j):
            sum: int = nums[i] + nums[j]

            if sum == k:
                count += 1
                i += 1
                j -= 1

            elif sum < k:
                i += 1

            else:
                j -= 1

        return count
