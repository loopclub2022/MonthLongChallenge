import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(Arrays.toString(sort(arr)));
    }

    static int[] sort(int[] arr){
        int evenCount = 0;
        for(int i =0;i<=arr.length-1;i++){
            if(arr[i]%2==0){
                swap(arr,i,evenCount);
                evenCount+=1;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
