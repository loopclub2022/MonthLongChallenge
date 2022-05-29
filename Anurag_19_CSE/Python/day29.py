# Link For Problem: https://leetcode.com/problems/maximum-product-of-word-lengths/

class Solution:

    """
        TC : O(n^2)

        SC : O(n)
    """

    def maxProduct(self, words: list[str]) -> int:
        mask: list[int] = []

        for word in words:
            mask.append(self.helper(word))

        ans: int = 0

        for i in range(len(words)):
            for j in range(len(words)):

                if i != j:
                    if not mask[i] & mask[j]:
                        ans = max(ans, len(words[i])*len(words[j]))

        return ans

    def helper(self, s: str) -> int:
        bit: int = 0

        for c in s:
            idx: int = ord(c)-ord('a')
            bit |= 1 << idx

        return bit
