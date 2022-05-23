//Link For Problem: https://leetcode.com/problems/ones-and-zeroes/

public class day23 {

    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (String s : strs) {
            int zero = 0, one = 0;

            for (char c : s.toCharArray()) {
                if (c == '0')
                    zero += 1;
                else
                    one += 1;
            }

            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {

                    if (one <= j && zero <= i)
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
