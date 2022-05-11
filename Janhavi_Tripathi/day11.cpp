/*Using 5 variables.
Here we are adding previous value with the current next element with serial of a-e-i-o-u.
Return by adding every element.
Time complexity: O(n).*/

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int countVowelStrings(int n) {
        int a=1,e=1,i=1,o=1,u=1;
        while(--n)
        {
            o+=u;
            i+=o;
            e+=i;
            a+=e;
        }
        return a+e+i+o+u;
    }
};