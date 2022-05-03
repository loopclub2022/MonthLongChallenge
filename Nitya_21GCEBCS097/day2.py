class Solution:

    def sortArrayByParity(self, num: list[int]) -> list[int]:
        j: int = 0

        for i in range(len(num)):

            if num[i] & 1 == 0:

                if i != j:
                    temp = num[i]
                    num[i] = num[j]
                    num[j] = temp

                j += 1

        return num

    def another_solution(self, num: list[int]) -> list[int]:
        j: int = 0

        for i, val in enumerate(num):

            if val & 1 == 0:
                temp = num[i]
                num[i] = num[j]
                num[j] = temp

                j += 1

        return num
