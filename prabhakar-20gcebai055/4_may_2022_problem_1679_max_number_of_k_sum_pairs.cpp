

#include <bits/stdc++.h>

using namespace std;

//Time = O(n)
// Aux Space = O(n)

/*Approach : 
# We store the elements of the array into hash-map with thier element as 'key' and frequency as 'value'
# We trasverse each value of the map  and look for a value which satisfies the given condition.
## if found we decrease the frequency of both the elements by 1

#we continue with the same value till we stop getting desired result 
## then we traverse for next value
*/

int maxOperations(int arr[],int n,int k){
	int res=0;
	unordered_map<int,int> m;

	//Time of this block O(n), Aux space of this block O(n)
	for(int i=0;i<n;i++){ //Storing values as {value : frequency}
		auto it = m.find(arr[i]);
		if(it != m.end())
			it->second++;
		else
			m.insert({arr[i],1});
	}

	// Total time of this block O(n) as here we are traversing value*frequency times => n (in worst case) 
	for(auto it = m.begin();it != m.end();it++){ //Traversing map
		while(it->second>0){ // looping till value is present
			it->second--;
			auto it2 = m.find(k-(it->first)); //checking if any value present in map satisying the given condition
			if(it2 != m.end() && (it2->second) >0 ){
				res++;
				it2->second--;
			}
			else // if not found we dont want to proceed any further with this value
				break;
		}
	}
	return res;
}

int main(void){
	int t,n,k;

	cin>>t;

	while(t--){
		cin>>n>>k;
		int arr[n];
		for(int i=0;i<n;i++)
			cin>>arr[i];
		cout<<maxOperations(arr,n,k)<<endl;
	}
	return 0;
}