# Link For Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

from collections import deque


class Solution:

    """
      Maintain a Map of all letter combinations.
      Keep adding the Permuations to the
      resultant List one by one.

      TC: O(4^n)

      SC: O(4^n)
    """

    def letterCombinations(self, digits: str) -> list[str]:
        if not digits:
            return []

        map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        res = []
        stack = [(0, "")]

        while(stack):
            i, combo = stack.pop()

            if(i == len(digits)):
                res.append(combo)

            else:
                next = digits[i]
                letter = map[next]

                for c in letter:
                    stack.append((i+1, combo+c))

        return res

    def iterative_bfs(self, digits: str) -> list[str]:
        if not digits:
            return []

        map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        res = []
        q = deque()
        q.append((0, ""))

        while q:
            i, combo = q.popleft()

            if i == len(digits):
                res.append(combo)

            else:
                next = digits[i]
                letter = map[next]

                for c in letter:
                    q.append((i+1, combo+c))

        return res

    def recursive_bfs(self, digits: str) -> list[str]:
        if not digits:
            return []

        map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        def recursive(i: int = 0, combo: str = "", res: list = []) -> None:
            if i == len(digits):
                res.append(combo)

            else:
                next = digits[i]
                letter = map[next]

                for c in letter:
                    recursive(i+1, combo+c, res)

            return res

        return recursive(0, "", [])
