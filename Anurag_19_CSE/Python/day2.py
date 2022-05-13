# Link For Problem: https://leetcode.com/problems/sort-array-by-parity/submissions/


class Solution:

    def sortArrayByParity(self, nums: list[int]) -> list[int]:
        j: int = 0

        for i in range(len(nums)):

            if nums[i] & 1 == 0:

                if i != j:
                    temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp

                j += 1

        return nums

    def another_solution(self, nums: list[int]) -> list[int]:
        j: int = 0

        for i, val in enumerate(nums):

            if val & 1 == 0:
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp

                j += 1

        return nums
