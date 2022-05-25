/*
  Question - https://leetcode.com/problems/coin-change/
  
  Time Complexity - O(amount*coins.length)
  Space Complexity - O(amount)
  Approach - For every amount less than the given amount, if possible, we count the number of coins for it.
             For every amount calculated yet, we further start adding up givn coins amount to get minimum coins required for givrn amount.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;
        for(int i = 1;i<=amount;i++)
            dp[i] = 10001;
        for(int i = 1;i<=amount;i++)
        {
            for(int c:coins)
            {
                if(i-c<0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i-c]+1);
            }
        }
        if(dp[amount] < 10001)
            return dp[amount];
        else
            return -1;
    }
}
