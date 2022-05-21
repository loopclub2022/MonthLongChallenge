//Link For Problem: https://leetcode.com/problems/coin-change/

import java.util.Arrays;

public class day21 {

    /*
     * TC : O(m*n)
     * 
     * SC : O(m*n)
     */

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];

        for (int i = 0; i < n + 1; i++) {

            for (int j = 0; j < amount + 1; j++) {

                if (j == 0)
                    dp[i][j] = 0;

                else if (i == 0)
                    dp[i][j] = (int) 1e5;

                else if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
            }
        }

        return dp[n][amount] > 1e4 ? -1 : dp[n][amount];
    }

    /*
     * TC : O(m*n + nlogn)
     * 
     * SC : O(n)
     */

    public int optimized(int coins[], int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;

        Arrays.sort(coins);

        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE - 1;

            for (int c : coins) {
                if (i - c < 0)
                    break;

                if (dp[i - c] != Integer.MAX_VALUE - 1)
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    /*
     * TC : O(m*n)
     * 
     * SC : O(n)
     */

    public int withoutSort(int coins[], int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {

                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
