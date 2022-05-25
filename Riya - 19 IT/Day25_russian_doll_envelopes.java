
/*
   Question - https://leetcode.com/problems/russian-doll-envelopes/
   Time Complexity  - O(n log n)
   Space Complexity - O(n)
   
   Approach - Example - Given [[1,15],[7,6],[2,200],[17,30],[17,45],[3,5],[17,3]]
              Sorted -        [[1,15],[2,200],[3,5],[7,6],[17,45],[17,30],[17,3]]
              Applying Longest increasing subsequence algo on height
              Initially - dp empty         len = 0;
              Insert - 15                  
              15                     len = 1       
              Insert - 200
              15
              15 , 200               len = 2
              Insert - 5
              5
              15, 200                len = 2               
              Insert - 6
              5
              5,6                    len = 2
              Insert - 45
              5
              5,6
              5,6,45                 len = 3
              Insert - 30
              5
              5,6
              5,6,30                 len = 3
              Insert - 3
              3
              5,6
              5,6,30                 len = 3
         
         Dp - [  3 , 6, 30 ]   len refers to last index where row value needs to exist 
*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
       Arrays.sort(envelopes,new Comparator<>()
       {  @Override
         public int compare(int[] arr1, int[] arr2){
            if(arr1[0]!=arr2[0])
                return arr1[0]-arr1[0];
            else
                return arr2[1]-arr1[1];
        }});
       // the array is sorted according to the length
        int[] dp=new int[envelopes.length];
        int len=0;
      
      // The further code is used to find longest increasing subsequences from heights
      // Thus, we will get the final sorted longest subarray.
        for(int i=0;i<envelopes.length;++i){
            int index=Arrays.binarySearch(dp,0,len,envelopes[i][1]);
            if(index<0){
                index=-index-1;
            }
            dp[index]=envelopes[i][1];
            if(index==len){
                len++;
            }
        }
        return len;
    }
    
}
