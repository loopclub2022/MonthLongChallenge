//Link For Problem: https://leetcode.com/problems/backspace-string-compare/

public class day1 {

    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));
    }

    private String convert(String str) {
        StringBuilder sb1 = new StringBuilder();

        for (char c : str.toCharArray()) {

            if (c == '#') {

                if (sb1.length() == 0)
                    continue;
                else
                    sb1.deleteCharAt(sb1.length() - 1);
            }

            else
                sb1.append(c);
        }

        return sb1.toString();
    }

    /*
     * END OF SOLUTION 1.
     * BELOW IS TWO POINTER APPROACH
     */

    public boolean twoPointer(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            int c1 = getNextValidIndex(s, i);
            int c2 = getNextValidIndex(t, j);

            if (c1 < 0 && c2 < 0)
                return true;

            if (c1 < 0 || c2 < 0)
                return false;

            if (s.charAt(c1) != t.charAt(c2))
                return false;

            i = c1 - 1;
            j = c2 - 1;
        }

        return true;
    }

    private int getNextValidIndex(String str, int idx) {
        int count = 0;

        while (idx >= 0) {

            if (str.charAt(idx) == '#')
                count += 1;

            else if (count > 0)
                count -= 1;

            else
                break;

            idx -= 1;
        }

        return idx;
    }
}
