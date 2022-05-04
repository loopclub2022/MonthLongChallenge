/*Problem statement: Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.*/

#include <bits/stdc++.h>

using namespace std;

// Time complexity -  θ(n)
// Aux space - θ(1)

//Approach - maintaining a subarray containing only even values

void sortArrayByParity(int arr[],int n){
	int index =0;
	for(int i=0;i<n;i++){
		if(arr[i]%2==0){
			swap(arr[i],arr[index]);
			index++;
		}
	}
}

/*
Code for running test cases on local machine

void printArray(int arr[],int n){
	for(int i=0;i<n;i++)
		cout<<arr[i]<<" ";
	cout<<endl;
}

int main(void){
	int t,n;

	cin>>t;

	while(t--){
		cin>>n;
		int arr[n];
		for(int i=0;i<n;i++)
			cin>>arr[i];
		sortArrayByParity(arr,n);
		printArray(arr,n);
	}
	return 0;
}*/