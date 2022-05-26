//Link For Problem: https://leetcode.com/problems/number-of-1-bits/

public class day26 {

    /*
     * TC : O(32) ==> O(1)
     * 
     * SC : O(1)
     */

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
