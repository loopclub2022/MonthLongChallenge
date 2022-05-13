//Link For Problem: https://leetcode.com/problems/count-sorted-vowel-strings/

import java.util.Arrays;

public class day11 {

    /*
     * For n = 3, let's see how many strings can be formed.
     * 
     * If start of the string is "aa", the third letter can be any of
     * {a, e, i, o, u} and the string will still be lexicographically
     * sorted. So there will be 5 strings. in total.
     * So, say"aa" -> 5.
     * 
     * If the start is "ae", the third letter can be {e, i, o, u}.
     * Note that a can't be the third letter, otherwise the string
     * will not be lexicographically sorted. So count of strings will
     * be 4.
     * 
     * So, say"ae" -> 4.
     * 
     * Similarly, for "ai" -> {i, o, u} -> 3.
     * 
     * "ao" -> {o, u} -> 2.
     * "au" -> {u} -> 1.
     * 
     * Now say start of the string is "ee".
     * 
     * "ee" -> {e, i, o, u} -> 4.
     * "ei" -> {i, o, u} -> 3.
     * "eo" -> {o, u} -> 2.
     * "eu" -> {u} -> 1.
     * 
     * Similarly,
     * 
     * "ii" -> {i, o, u} -> 3.
     * "io" -> {o, u} -> 2.
     * "iu" -> {u} -> 1.
     * "oo" -> {o, u} -> 2.
     * "ou" -> {u} -> 1.
     * "uu" -> {u} -> 1.```
     * 
     * Hence in total, there would be -
     * 
     * 5 + 4 + 3 + 2 + 1 +
     * 4 + 3 + 2 + 1 +
     * 3 + 2 + 1 +
     * 2 + 1 +
     * 1
     * = 35
     * 
     * TC : O(n^2)
     * 
     * SC : O(1)
     */

    public int countVowelStrings(int n) {
        int ans = 0;

        for (int i = 1; i <= (n + 1); i++) {
            int sum = 0;

            for (int j = 1; j <= i; j++) {
                sum += j;
                ans += sum;
            }
        }

        return ans;
    }

    /*
     * For n = 2
     * 
     * a => (a, e,i,o,u)
     * e => (e,i,o,u)
     * i => (i, o, u)
     * o => (o, u)
     * u => (u)
     * 
     * The resultant strings are:
     * 
     * aa, ae, ai, ao, au
     * ee, ei, eo, eu
     * ii, io, iu
     * oo, ou
     * uu
     * 
     * For n = 3
     * 
     * aa => (a,e,i,o,u) 5
     * ae => (e, i, o, u) 4
     * ai => (i, o, u) 3
     * ao => (o, u) 2
     * au => u 1
     * 
     * ee => (e,i,o,u) 4
     * ei => (i,o,u) 3
     * eo => (o,u) 2
     * eu => (u) 1
     * 
     * 
     * ii => (i,o,u) 3
     * io => (o,u) 2
     * iu => (u) 1
     * 
     * oo => (o,u) 2
     * ou => (u) 1
     * 
     * uu => (u) 1
     * 
     * TC : O(n)
     * 
     * SC : O(1)
     */

    public int anotherSolution(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;

        for (int j = 1; j < n; j++) {

            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            // u = u; (Not Required)
        }

        return a + e + i + o + u;
    }

    /*
     * TC : O(n)
     * 
     * SC : O(1)
     */

    public int easySolution(int n) {
        int ans[] = new int[5];
        Arrays.fill(ans, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 3; j >= 0; j--) {

                ans[j] += ans[j + 1];
            }
        }

        return ans[0];
    }

    /*
     * TC : O(n) + O(n) => O(n)
     * 
     * SC : O(1)
     */

    public int sameAsAbove(int n) {
        int ans[] = new int[5];
        Arrays.fill(ans, 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 3; j >= 0; j--) {

                ans[j] += ans[j + 1];
            }
        }

        int sum = 0;
        for (int i : ans)
            sum += i;

        return sum;
    }

    /*
     * TC : O(n)
     * 
     * SC : O(n)
     */

    public int uselessDP(int n) {
        int dp[][] = new int[n][5];

        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        for (int i = 0; i < 5; i++)
            dp[0][i] = i + 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][4];
    }
}
