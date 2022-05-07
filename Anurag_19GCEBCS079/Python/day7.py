# Link For Problem : https://leetcode.com/problems/132-pattern/

class Solution:

    """
      For Optimized Approach,
      Maintain a Monotonically Decreasing Stack.

      Push Only the Greater Element ('3rd element' in '132') in the stack.

      If top of the stack is less than the current element
      then pop the top of the stack.

      Check if the current element ('1st element' in '132') is less than the
      maintained
      third variable which keeps track of the '2nd element' in '132'.

      If yes, then return true.

      Refer : https://www.youtube.com/watch?v=q5ANAl8Z458

      TC: O(n)

      SC: O(n)

    """

    def find132pattern(self, nums: list[int]) -> bool:
        stack = []
        currMin = nums[0]

        for i in nums[1:]:

            while stack and i >= stack[-1][0]:
                stack.pop()

            if stack and i > stack[-1][1]:
                return True

            stack.append([i, currMin])
            currMin = min(currMin, i)

        return False

    def another_solution(self, nums: list[int]) -> bool:
        stack = []
        third = float('-inf')

        for i in nums[::-1]:

            if i < third:
                return True

            while stack and i > stack[-1]:
                third = stack.pop()

            stack.append(i)

        return False
