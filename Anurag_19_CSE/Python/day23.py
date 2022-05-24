# Link For Problem: https://leetcode.com/problems/ones-and-zeroes/

from typing import Counter


class Solution:

    def findMaxForm(self, strs: list[str], m: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]

        for s in strs:
            map: dict = Counter(s)

            zero: int = map["0"]
            one: int = map["1"]

            # for c in s:
            #     if c == '0':
            #         zero += 1
            #     else:
            #         one += 1

            for i in range(m, zero-1, -1):

                for j in range(n, one-1, -1):

                    dp[i][j] = max(dp[i][j], dp[i-zero][j-one]+1)

        return dp[m][n]
