//Link For Problem: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class day27 {

    /*
     * TC : O(logn)
     * 
     * SC : O(1)
     */

    public int numberOfSteps(int num) {
        if (num == 0)
            return 0;

        if (num == 1)
            return 1;

        int count = 0;

        while (num > 0) {
            if ((num & 1) == 0)
                num >>= 1;
            else
                num -= 1;

            count += 1;
        }

        return count;
    }

    /*
     * TC : O(logn)
     * 
     * SC : O(n)
     */

    public int oneLiner(int num) {
        return Integer.toBinaryString(num).length() - 1 + Integer.bitCount(num);
    }
}
