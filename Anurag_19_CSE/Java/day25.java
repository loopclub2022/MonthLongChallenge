//Link For Problem: https://leetcode.com/problems/russian-doll-envelopes/

import java.util.Arrays;

public class day25 {

    /*
     * TC : O(nlogn)
     * 
     * SC : (n)
     */

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int lis[] = new int[envelopes.length + 1];

        Arrays.fill(lis, Integer.MAX_VALUE);

        lis[0] = Integer.MIN_VALUE;

        int ans = 0;

        for (int i = 0; i < envelopes.length; i++) {
            int val = envelopes[i][1];
            int insert = binarySearch(lis, val);

            ans = Math.max(ans, insert);

            if (lis[insert] >= val)
                lis[insert] = val;
        }

        return ans;
    }

    static int binarySearch(int dp[], int val) {
        int low = 0, high = dp.length - 1, result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (dp[mid] < val) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result + 1;
    }
}
