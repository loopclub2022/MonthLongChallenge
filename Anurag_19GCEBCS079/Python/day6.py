# Link For Problem : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/


class Solution:

    """
      Use Two Stacks.

      First Stack to store the
      valid characters.

      Second Stack to store the
      count of characters at each step.

      If Repetetive characters are found then
      increase the count by 1.

      If count=k then pop k elements from the
      character stack.

      Finally Add all the characters to a String and
      reverse it.

      TC: O(nk)

      SC: O(n) + O(n) = 2O(n) => O(n)

    """

    def removeDuplicates(self, s: str, k: int) -> str:
        arr: list = [0]*len(s)
        res = []

        for c in s:
            res.append(c)
            current: int = len(res)-1

            if current > 0 and res[current] == res[current-1]:
                arr[current] = arr[current-1]+1
            else:
                arr[current] = 1

            if arr[current] == k:
                for i in range(k):
                    res.pop()

        return ''.join(res)

    """
        Save the character c and its count to the stack.

        If the next character c is same as the last one, increment the count.

        Otherwise push a pair (c, 1) into the stack

        TC : O(n)

        SC: O(n)
    """

    def another_solution(self, s: str, k: int) -> str:
        stack = [['#', 0]]

        for c in s:

            if stack[-1][0] == c:
                stack[-1][1] += 1

                if stack[-1][1] == k:
                    stack.pop()

            else:
                stack.append([c, 1])

        return ''.join(c*k for c, k in stack)
