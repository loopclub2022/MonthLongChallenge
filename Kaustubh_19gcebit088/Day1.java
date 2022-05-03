// https://leetcode.com/problems/backspace-string-compare/

public class Day1<ans> {
    public static void main(String[] args) {
        String a = "ab#c";
        String b = "ab#c";
        System.out.println(getStr(a));
    }

    static String getStr(String a) {
        char[] ch = (a).toCharArray();
        String ans = "";
        int len = ch.length - 1;
        int i = 0;
        while (i <= len) {
            if (ch[i] != '#') {
                ans += ch[i];

            } else if (ans.length() != 0) {
                ans = ans.substring(0, ans.length() - 1);
            }
            ++i;

        }
        return ans;
    }
}

