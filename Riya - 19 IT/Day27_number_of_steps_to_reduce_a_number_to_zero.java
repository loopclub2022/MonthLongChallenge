/*
     Question - https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
     
     Time Complexity - O(log n)
     Space Complexity - O(1)
     
     Approach - For any given number , for example - 22
                binary of 22 is - 10110
                To calculate, its length ->    floor( log (22) / log (2) ) + 1 = 5
                thus we know, binary number is of 5 length,
                we calculate set bits in number = 3
                we calculate not set (0) bits   = 5 -3 = 2 
                and we also, observe the trend according to which, 
                steps to reduce = count0 + (2*count1) - 1
                                = 2 + (2*3) - 1
                                = 7
*/

class Solution {
    public int numberOfSteps(int n) {
        if(n==0)
            return 0;
        int length = (int)(Math.floor(Math.log(n) / Math.log(2))) + 1;
        int count1 = countSetBits(n);
        return (length-count1) + 2*count1 - 1;
    } 
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
