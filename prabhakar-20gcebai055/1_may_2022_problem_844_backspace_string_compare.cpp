/*Problem statement : Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.*/

#include <bits/stdc++.h>

using namespace std;

// Time complexity -  O(3n) => O(n)
// Aux space - θ(1)

//Approach - maintaining a substring which follows the given conditions

bool backspaceCompare(string s,string t){
	int depth1=0;
	int depth2=0;

	for(int i=0;i<s.length();i++){
		if(s[i]=='#'){
			if(depth1>0){
				depth1--;
			}
		}
		else{
			s[depth1] = s[i];
			depth1++;
		}
	}

	for(int i =0;i<t.length();i++){
		if(t[i]=='#'){
			if(depth2>0){
				depth2--;
			}
		}
		else{
			t[depth2] = t[i];
			depth2++;
		}
	}
	if(depth1==depth2){
		for(int i=0;i<depth1;i++)
			if(s[i]!=t[i])
				return false;

		return true;
	}

	return false;
}

/*
Code for running test cases on local machine

int main(void){
	int test_cases;
	string s,t;

	cin>>test_cases;
	while(test_cases--){
		cin>>s>>t;
		cout<<boolalpha<<backspaceCompare(s,t)<<endl;
	}

	return 0;
}*/