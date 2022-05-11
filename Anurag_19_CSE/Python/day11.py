# Link For Problem: https://leetcode.com/problems/count-sorted-vowel-strings/


class Solution:

    """
      For n = 3, let's see how many strings can be formed.

      If start of the string is "aa", the third letter can be any of
      {a, e, i, o, u} and the string will still be lexicographically
      sorted. So there will be 5 strings. in total.
      So, say"aa" -> 5.

      If the start is "ae", the third letter can be {e, i, o, u}.
      Note that a can't be the third letter, otherwise the string
      will not be lexicographically sorted. So count of strings will
      be 4.

      So, say"ae" -> 4.

      Similarly, for "ai" -> {i, o, u} -> 3.

      "ao" -> {o, u} -> 2.
      "au" -> {u} -> 1.

      Now say start of the string is "ee".

      "ee" -> {e, i, o, u} -> 4.
      "ei" -> {i, o, u} -> 3.
      "eo" -> {o, u} -> 2.
      "eu" -> {u} -> 1.

      Similarly,

      "ii" -> {i, o, u} -> 3.
      "io" -> {o, u} -> 2.
      "iu" -> {u} -> 1.
      "oo" -> {o, u} -> 2.
      "ou" -> {u} -> 1.
      "uu" -> {u} -> 1.```

      Hence in total, there would be -

      5 + 4 + 3 + 2 + 1 +
      4 + 3 + 2 + 1 +
      3 + 2 + 1 +
      2 + 1 +
      1
      = 35

      TC : O(n^2)

      SC : O(1)
    """

    def countVowelStrings(self, n: int) -> int:
        ans: int = 0

        for i in range(1, n+2):
            sum: int = 0

            for j in range(1, i+1):
                sum += j
                ans += sum

        return ans

    """
      For n = 2
      
      a => (a, e,i,o,u)
      e => (e,i,o,u)
      i => (i, o, u)
      o => (o, u)
      u => (u)
      
      The resultant strings are:
      
      aa, ae, ai, ao, au
      ee, ei, eo, eu
      ii, io, iu
      oo, ou
      uu
      
      For n = 3
      
      aa => (a,e,i,o,u) 5
      ae => (e, i, o, u) 4
      ai => (i, o, u) 3
      ao => (o, u) 2
      au => u 1
      
      ee => (e,i,o,u) 4
      ei => (i,o,u) 3
      eo => (o,u) 2
      eu => (u) 1
      
      
      ii => (i,o,u) 3
      io => (o,u) 2
      iu => (u) 1
      
      oo => (o,u) 2
      ou => (u) 1
      
      uu => (u) 1
      
      TC : O(n)
      
      SC : O(1)
    """

    def another_solution(self, n: int) -> int:
        a, e, i, o, u = 1, 1, 1, 1, 1

        for i in range(1, n+1):

            a = a+e+i+o+u
            e = e+i+o+u
            i = i+o+u
            o = o+u
            # u=u (Not Required)

        return a+e+i+o+u

    """
      TC : O(n)
      
      SC : O(1)
    """

    def easy_solution(self, n: int) -> int:
        ans = [1]*5

        for i in range(0, n):
            for j in range(3, -1, -1):

                ans[j] += ans[j+1]

        return ans[0]

    """ 
        TC : O(n)

        SC : O(1)
    """

    def sameAsAbove(self, n: int) -> int:
        ans = [1]*5

        for i in range(2, n+1):
            for j in range(3, -1, -1):

                ans[j] += ans[j+1]

        return sum(ans)

    """
        TC : O(n)

        SC : O(n)
    """

    def useless_DP(self, n: int) -> int:
        dp = [[0] * 6 for _ in range(n+1)]

        for i in range(1, 6):
            dp[1][i] = i

        for i in range(2, n+1):
            dp[i][1] = 1

            for j in range(2, 6):
                dp[i][j] = dp[i][j-1] + dp[i-1][j]

        return dp[n][5]
