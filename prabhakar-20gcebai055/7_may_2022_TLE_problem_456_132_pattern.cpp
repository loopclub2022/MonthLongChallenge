#include <bits/stdc++.h>

using namespace std;

/*
TLE

Time : O(n^2)
Aux space : O(1)

Approach : we use use window sliding technique and create a window of 3 elements
we keep on checking if the windows satisfies the given conditions or not 
if yes we return true 
else we traverse element in left of current index and right of current index to check if there are any elements which satisfy the condition
if yes we return true 
*/

bool find132pattern(vector<int>& nums) {
    if(nums.size()<3)
        return false;


    for(int i=1;i<nums.size()-1;i++){
        if(nums[i-1] < nums[i+1] && nums[i+1] < nums[i])
                return true;
        else{
            int high = i;
            int low = i;
            for(int j=i+1;j<nums.size();j++){
                if(nums[j]<nums[i]&&(high==i||nums[j]>nums[high]))
                    high = j;
            }

            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[high]&&(low==i||nums[j]<nums[low]))
                    low = j;
            }
            if(low!=i && high !=i)
                return true;
        }

    }
    return false;
}

/*
Code to test program on local machine

int main(void){
	int t,n;

	cin>>t;

	while(t--){
		cin>>n;
		std::vector<int> nums(n);
		for(int i=0;i<n;i++)
			cin>>nums[i];

		cout<<boolalpha<<find123pattern(nums)<<endl;
	}
	return 0;
}*/