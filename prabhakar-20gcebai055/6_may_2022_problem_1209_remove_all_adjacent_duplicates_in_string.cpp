/*Problem statement : You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.*/

#include <bits/stdc++.h>

using namespace std;

/*Time complexity : O(n)
Aux Space : O(n)

Approach : We are maintaing a stack pair with each pair having a 'character' and its consecutive 'frequenecy'

we will keep incrementing the frequency till we encounter another character from the string.
now we will check if frequency of previous character is greater than the required adjacent frequency 'k'

if yes then we will remove consecutive frequency from stack in multiples of 'k'.
    if stack frequency becomes 0 we pop the stack (removing character from the stack)

if our frequency is less than the required adjacent frequency 'k'
    then we simply push new character into stack and set its consecutive frequency as 1

we keep doing same thing until we traverse through all the characters of string

after that we start popping the stack and concatinate the characters with the times of thier frequency
since stack follows LIFO we will have our required string in reverse order

therefore we will reverse the string to get our result
*/


string removeDuplicates(string s, int k) {
    stack<pair<char,int>> char_freq;

    char_freq.push({s[0],1});
    
    for(int i=1;i<s.length();i++){
        if(char_freq.empty()){
            char_freq.push({s[i],1});
            continue;
        }

        if(s[i]==char_freq.top().first)
            char_freq.top().second++;
        else{
            if(char_freq.top().second>=k){
                int total = char_freq.top().second/k;
                if(char_freq.top().second%k==0){
                    char_freq.pop();
                }
                else
                    char_freq.top().second -= total*k;
                i--;
                continue;
            }
            char_freq.push({s[i],1});
        }
    }

    if(!char_freq.empty()&&char_freq.top().second>=k){ // checking for corner case
        int total = char_freq.top().second/k;
        if(char_freq.top().second%k==0)
            char_freq.pop();
        else
            char_freq.top().second -= total*k;	
    }
    s ="";
    while(!char_freq.empty()){
        while(char_freq.top().second--)
            s += char_freq.top().first;
        char_freq.pop();
    }
    reverse(s.begin(),s.end());
    return s;
}

/*
Code to run program in local machine

int main(void){
	int t,k;
	string s;

	cin>>t;

	while(t--){
		cin>>s>>k;
		cout<<removeAdjacents(s,k)<<endl;
		cout<<endl;
	}
	return 0;
}*/