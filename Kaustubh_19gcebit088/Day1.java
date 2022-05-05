// https://leetcode.com/problems/backspace-string-compare/

// time complexity = O(n)
// space complexity = O(1)

// approach:
// traverse through the whole char arr 
// for every element which is not '#'
//     add it to ans string
// and for every element which is '#', 
//     remove the last added element from ans string only if it is not empty



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

