# Link For Problem: https://leetcode.com/problems/russian-doll-envelopes/

class Solution:

    """
        TC : O(nlogn)

        SC : O(n)
    """

    def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        res = []

        for _, h in envelopes:
            l, r = 0, len(res)-1

            while l <= r:
                mid = (l+r) >> 1

                if res[mid] >= h:
                    r = mid-1
                else:
                    l = mid+1

            idx = l

            if idx == len(res):
                res.append(h)
            else:
                res[idx] = h

        return len(res)
