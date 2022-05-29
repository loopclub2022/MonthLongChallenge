//Link For Problem: https://leetcode.com/problems/maximum-product-of-word-lengths/

public class day29 {

    /*
     * TC : O(n^2)
     * 
     * SC : O(n)
     */

    public int maxProduct(String[] words) {
        int n = words.length;
        int mask[] = new int[n];

        for (int i = 0; i < n; i++)
            mask[i] = helper(words[i]);

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if ((mask[i] & mask[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }

        return max;
    }

    private int helper(String s) {
        int bit = 0;

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            bit |= 1 << index;
        }

        return bit;
    }
}
