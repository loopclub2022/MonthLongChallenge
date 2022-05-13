# Link For Problem: https://leetcode.com/problems/combination-sum-iii/

class Solution:

    """
        Question involves Backtracking.

        TC : O(9!)

        SC : O(9!)

    """

    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        nums: list = [i for i in range(1, 10)]
        res: list = []

        self.helper(res, nums, k, [], n)

        return res

    def helper(self, res: list, nums: list, k: int, path: list, t: int) -> None:

        if k < 0 or t < 0:
            return

        if len(path) == k and t == 0:
            res.append(path)

        for i in range(len(nums)):

            if nums[i] > t:
                continue

            self.helper(res, nums[i+1:], k, path+[nums[i]], t-nums[i])
