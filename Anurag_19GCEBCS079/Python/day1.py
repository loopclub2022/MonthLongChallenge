# Link For Problem: https://leetcode.com/problems/backspace-string-compare/


class Solution:

    def getNextValidIndex(self, s: str, idx: int) -> int:
        count: int = 0

        while(idx >= 0):

            if s[idx] == '#':
                count += 1

            elif count > 0:
                count -= 1

            else:
                break

            idx -= 1

        return idx

    def backspaceCompare(self, s: str, t: str) -> bool:
        i, j = len(s)-1, len(t)-1

        while(i >= 0 or j >= 0):
            c1: int = self.getNextValidIndex(s, i)
            c2: int = self.getNextValidIndex(t, j)

            if c1 < 0 and c2 < 0:
                return True

            if c1 < 0 or c2 < 0:
                return False

            if s[c1] != t[c2]:
                return False

            i = c1-1
            j = c2-1

        return True
