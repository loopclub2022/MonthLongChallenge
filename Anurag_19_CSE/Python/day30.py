# Link For Problem: https://leetcode.com/problems/divide-two-integers/

class Solution:

    def divide(self, dividend: int, divisor: int) -> int:
        is_negative = (dividend < 0) != (divisor < 0)

        divisor, dividend = abs(divisor), abs(dividend)

        quotient = 0
        the_sum = divisor

        while the_sum <= dividend:
            current_quotient = 1

            while (the_sum << 1) <= dividend:
                the_sum <<= 1
                current_quotient <<= 1

            dividend -= the_sum
            the_sum = divisor
            quotient += current_quotient

        return min(2147483647, max(-quotient if is_negative else quotient, -2147483648))
