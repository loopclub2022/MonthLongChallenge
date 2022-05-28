# Link For Problem: https://leetcode.com/problems/missing-number/

class Solution:

    """
        TC : O(n)

        SC : O(1)
    """

    def missingNumber(self, nums: list[int]) -> int:
        n: int = len(nums)

        return (n*(n+1))//2 - sum(nums)
