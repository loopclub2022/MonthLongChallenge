/*Problem statement: Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.*/

#include <bits/stdc++.h>

using namespace std;

// Time complexity -  θ(2n) => θ(n)
// Aux space - θ(1)

/*
Approach - Using monotonic stack concept
We are maintaing virtual monotonic stack with top of the stack as "Index". 

We are also maintaining two indices for max uppar bound and min lower bound of resultant subarray. 
We update the indices as soon as we encounter an index which dont follow monotonic stack
else we update top of the stack i.e "Index"
*/

int shortestSubarray(std::vector<int> &nums){
	int start = -1;
	int end = -1;
	int index = 0;

	for(int i=1;i<nums.size();i++){
		if(nums[i]<nums[index])
			end  = i;
		else
			index = i;
	}

	index = nums.size()-1;
	for(int i=nums.size()-2;i>=0;i--){
		if(nums[i]>nums[index])
			start = i;
		else 
			index=i;
	}

	if(start==-1&&end==-1)
		return 0;

	return end - start + 1;
}
/*
Code for running test cases on local machine

int main(void){
	int t,n;
	
	cin>>t;
	while(t--){
		cin>>n;
		std::vector<int> nums(n);

		for(int i=0;i<n;i++)
			cin>>nums[i];
		cout<<shortestSubarray(nums)<<endl;
	}
	return 0;
}