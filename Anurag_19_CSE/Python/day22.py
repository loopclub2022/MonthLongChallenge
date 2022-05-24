# Link For Problem: https://leetcode.com/problems/palindromic-substrings/

class Solution:

    def countSubstrings(self, s: str) -> int:
        if len(s) == 0:
            return 0

        if len(s) == 1:
            return 1

        ans: int = 0

        for i in range(len(s)):
            ans += self.count_palindrome(s, i, i)
            ans += self.count_palindrome(s, i, i+1)

        return ans

    def count_palindrome(self, s: str, start: int, end: int) -> int:
        count: int = 0

        while start >= 0 and end < len(s) and s[start] == s[end]:
            start -= 1
            end += 1
            count += 1

        return count
