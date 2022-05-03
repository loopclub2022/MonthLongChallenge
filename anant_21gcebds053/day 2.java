class Solution {
    public int[] sortArrayByParity(int[] nums) {
              
		int i,k=0,r;
		
		int b[]= new int[nums.length];
	
       
       
        for(i=0;i<nums.length;i++)
        {
            if((nums[i]%2)==0)
            {
                b[k]=nums[i];
                k++;
            }
        }
        r=k;
         for(i=0;i<nums.length;i++)
         {
             if((nums[i]%2)!=0)
             {
                 b[r]=nums[i];
                 r++;
             }
         }
        return b;
	}
}



        
    
