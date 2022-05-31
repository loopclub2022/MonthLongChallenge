/*
   Question - https://leetcode.com/problems/divide-two-integers/
   Time Complexity - O(log(dividend))
   Space Complexity - O(1)
   Approach = Bit Manipulation
*/

class Solution {
    public int divide(int dividend, int divisor) {
        long result = dividel(dividend, divisor);
        if(result>Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE) result = Integer.MIN_VALUE;
        return (int)result;
    }

    public static long dividel(long dividend, long divisor)
    {
        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        long quotient = 0, temp = 0;
        for (int i = 31; i >= 0; --i)
        {
            if (temp + (divisor << i) <= dividend)
            {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }
        if(sign==-1)
            quotient=-quotient;
        return quotient;
    }
}
