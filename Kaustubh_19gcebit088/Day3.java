// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/submissions/

// time complexity = O(n)
// space complexity = O(1)

// approach:

// maintain a min and max and compare each element from front and back to these values and update them.
// if element from start is smaller than max, then assign end to that index
// if element from end is greater than min, then assign the start index to that index
// length of resultant will be end - start +1


import java.util.Arrays;

public class Day3 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,2};
        System.out.println(getlenCORRECT(arr));
    }


    static int getlenCORRECT(int[] A){
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }


}
