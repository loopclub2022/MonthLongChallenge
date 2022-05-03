/* intution behind this approach is-> if the array is sorted then max from left to right is equal to min from right to left, so our range will be those element which are not equal
for example
 consider an array [2,4,3,6,5,7]
 find out the left max->[2,4,4,6,6,7]
 find out the right min->[2,3,3,5,5,7]
so you can see element which are already sorted is same in left max and right min which is 2 and 7 else need to be sorted, that is the range
Time Complexity- O(N)
Space Complexity- O(N)
*/

class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int n1=nums.size();
        int leftmax[n1];
        int rightmax[n1];
        leftmax[0]=nums[0];
        rightmax[n1-1]=nums[n1-1];
        for(int i=1;i<n1;i++)
        {
            leftmax[i]=max(leftmax[i-1],nums[i]);
        }
        for(int j=n1-2;j>=0;j--)
        {
            rightmax[j]=min(rightmax[j+1],nums[j]);
        }
        int i=0,j=n1-1;
        while(i<n1)
        {
            if(leftmax[i]==rightmax[i])
            {
                i++;
            }
            else
            {
                break;
            }
        }
        while(j>=0)
        {
            if(leftmax[j]==rightmax[j])
            {
                j--;
            }
            else
            {
                break;
            }
        }
        return i<j?j-i+1:0;
        
    }
};
