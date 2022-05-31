# Link For Problem: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

class Solution:

    """
        TC : O(nk)

        SC : O(nk)
    """

    def hasAllCodes(self, s: str, k: int) -> bool:
        total = 1 << k

        have = set()

        for i in range(len(s)-k+1):
            temp = s[i:i+k]

            if temp not in have:
                have.add(temp)
                total -= 1

                if total == 0:
                    return True

        return False
