# Link For Problem: https://leetcode.com/problems/permutations-ii/


class Solution:

    """
        This solution involves a Map.

        Maintain a frequency map of all the unique elements.

        Rest is standard Backtracking.

        TC: O(n!)

        SC: O(n)
    """

    def permuteUnique(self, nums: list[int]) -> list[list[int]]:
        ans = []
        perm = []
        map = {}

        for i in nums:

            if i in map:
                map[i] += 1
            else:
                map[i] = 1

        def dfs():

            if len(perm) == len(nums):
                ans.append(perm.copy())
                return

            for i in map:

                if map[i] > 0:
                    perm.append(i)
                    map[i] -= 1

                    dfs()

                    map[i] += 1
                    perm.pop()

        dfs()

        return ans
