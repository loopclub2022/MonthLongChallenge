# Link For Problem: https://leetcode.com/problems/coin-change/

class Solution:

    """
        TC : O(m*n)

        SC : O(n)
    """

    def coinChange(self, coins: list[int], amount: int) -> int:
        if amount == 0:
            return 0

        if amount < min(coins):
            return -1

        check = [-1 for i in range(amount+1)]

        for i in coins:

            if i > len(check)-1:
                continue

            check[i] = 1

            for j in range(i+1, amount+1):

                if check[j-i] == -1:
                    continue

                elif check[j] == -1:
                    check[j] = check[j-i]+1

                else:
                    check[j] = min(check[j], check[j-i]+1)

        return check[-1]
