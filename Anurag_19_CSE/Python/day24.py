# Link For Problem: https://leetcode.com/problems/longest-valid-parentheses/

class Solution:

    """ 
        TC : O(n)

        SC : O(n)
    """

    def longestValidParentheses(self, s: str) -> int:
        ans: int = 0
        stack: list[int] = []

        stack.append(-1)

        for i, c in enumerate(s):

            if c == '(':
                stack.append(i)

            else:
                stack.pop()

                if not stack:
                    stack.append(i)

                else:
                    ans = max(ans, i-stack[-1])

        return ans
