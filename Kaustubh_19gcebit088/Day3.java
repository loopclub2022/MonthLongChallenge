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
//    static int getlen(int[] arr){
//        int[] ans = getidx(arr);
//        if(ans[0]==-1&&ans[1]==-1) return 0;
//        else return ans[1]-ans[0]+1;
//    }
//
//    static int[] getidx(int[] arr){
//        int s = 0, e = arr.length-1;
//        int[] ans = {-1,-1};
//        while(s<e){
//            if(arr[s]>arr[s+1]){
//                ans[0] = s;
//                break;
//            }
//            s+=1;
//        }
//
//        while(s<e){
//            if(arr[e]<=arr[e-1]){
//                ans[1] = e;
//                break;
//            }
//            e-=1;
//        }
//
//        return ans;
//    }

}
