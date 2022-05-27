# Link For Problem: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

class Solution:

    """
        TC : O(logn)

        SC : O(1)
    """

    def numberOfSteps(self, num: int) -> int:
        if num == 0:
            return 0

        if num == 1:
            return 1

        ans: int = 0

        while num > 0:

            if (num & 1) == 0:
                num >>= 1
            else:
                num -= 1

            ans += 1

        return ans

    """
        TC : O(logn)

        SC : O(1)
    """

    def another_solutuin(self, num: int) -> int:
        if num == 0:
            return 0

        bit_string = bin(num)[2:]

        return len(bit_string)-1 + bit_string.count('1')
