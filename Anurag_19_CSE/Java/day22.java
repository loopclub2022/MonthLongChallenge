//Link For Problem: https://leetcode.com/problems/palindromic-substrings/

public class day22 {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        if (s.length() == 1)
            return 1;

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += countPalindrome(s, i, i);
            ans += countPalindrome(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start -= 1;
            end += 1;
            count += 1;
        }

        return count;
    }
}
