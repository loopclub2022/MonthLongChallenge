# Link For Problem: https://leetcode.com/problems/number-of-1-bits/

class Solution:

    """
        TC : O(32) ==> O(1)

        SC : O(1)
    """

    def hammingWeight(self, n: int) -> int:
        ans: int = 0

        while n:
            ans += 1
            n = n & (n-1)

        return ans
