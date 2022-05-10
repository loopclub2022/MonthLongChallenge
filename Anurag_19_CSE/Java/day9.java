//Link For Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class day9 {

    /*
     * Maintain a Map of all letter combinations.
     * Keep adding the Permuations to the
     * resultant List one by one.
     * 
     * TC: O(4^n)
     * 
     * SC: O(4^n)
     */

    static Map<Character, String> mp = Map.of('1', "", '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7',
            "pqrs", '8', "tuv", '9', "xyzw");

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0 || digits == null)
            return res;

        helper(digits, res, 0, new StringBuilder());

        return res;
    }

    private void helper(String digits, List<String> res, int idx, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = idx; i < digits.length(); i++) {
            String temp = mp.get(digits.charAt(i));

            for (int j = 0; j < temp.length(); j++) {
                sb.append(temp.charAt(j));
                helper(digits, res, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> anotherSolution(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return res;

        dfs(digits, 0, new StringBuilder(), res);

        return res;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = map[digits.charAt(index) - '0'];

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
