//Link For Problem: https://leetcode.com/problems/longest-valid-parentheses/

import java.util.ArrayDeque;

public class day24 {

    /*
     * TC : O(n)
     * 
     * SC : O(n)
     */

    public int longestValidParentheses(String s) {
        int ans = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.offerFirst(-1);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                dq.offerFirst(i);

            else {
                dq.pollFirst();

                if (dq.isEmpty())
                    dq.offerFirst(i);

                else
                    ans = Math.max(ans, i - dq.peekFirst());
            }
        }

        return ans;
    }
}
