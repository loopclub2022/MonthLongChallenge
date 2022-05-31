//Link For Problem: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

import java.util.HashSet;

public class day31 {

    /*
     * TC : O(nk)
     * 
     * SC : O(nk)
     */

    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < s.length() - k + 1; i++) {
            String temp = s.substring(i, i + k);

            if (!hs.contains(temp)) {
                hs.add(temp);
                need -= 1;

                if (need == 0)
                    return true;
            }
        }

        return false;
    }
}
