/*Problem statement : Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.*/

#include <bits/stdc++.h>

using namespace std;

// Total time = O(2n) => O(n)
// Aux Space = O(n)

/*Approach : 
# We store the elements of the array into hash-map with thier element as 'key' and frequency as 'value'
# We trasverse the array and look for a value in map which satisfies the given condition.

## if found we traverse the ramaining array to get the index of that value */

std::vector<int> twoSum(std::vector<int> &nums,int target){
	unordered_map<int,int> m;

	//Time of this block O(n), Aux space of this block O(n)
	for(int i=0;i<nums.size();i++){ //Storing values as {value : frequency}
		auto it = m.find(nums[i]);
		if(it != m.end())
			it->second++;
		else
			m.insert({nums[i],1});
	}

	//Total time of this block = O(n), as searching in hash map is O(1) on average
	for(int i=0;i<nums.size();i++){  
		auto it = m.find(target-nums[i]); //Searching value in the hash-map, 
		if(it != m.end()){ // if its found
			for(int j=i+1;j<nums.size();j++){ // Run remaing loop as it's sure that the number can't be present before current index or this loop would have executed earlier
				if(nums[i]+nums[j] == target)
					return {i,j};
			}
		}
	}
	return {-1,-1};
}

int main(void){
	int t,n,k;

	cin>>t;

	while(t--){
		cin>>n>>k;
		std::vector<int> nums(n);
		for(int i=0;i<n;i++)
			cin>>nums[i];
		std::vector<int> output;
		output = twoSum(nums,k);
		cout<<"["<<output[0]<<","<<output[1]<<"]"<<endl;
	}
	return 0;
}