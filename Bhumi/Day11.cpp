//Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

//A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.


//Approach ---> Here in this question we can see the patter as
// eg = if n = 1 then it's clear we've 5 vowels a, e, i, o ,u ..so n = 1 then we can've lexicographical string in sorted order as a, e, i, o , u hence output is = 5
//lets take n = 2 --> then 
//a , e, i , o , u ---> the possible string in lexicographical sorted order are as --> aa, ae, ai, ao , au, ee, ei, eo, eu, ii, io, iu, oo, ou, uu. (as we know ea is not possible coz it's not in sorted order)
//hence the output  = 15
//if we see when n = 1--> 
                                                                             //a , e , i ,o, u
                                                                             //1 , 1 , 1 ,1, 1
//when n = 2 --> the possible string which we can make using a e i o u are   //5,  4  , 3, 2, 1
//let's take n = 3 --> the possible string are aaa, aae, aai,aau, aao, eei, eee,eeo,eeu, iii, iio, iiu, ooo, oou,ouu,uuu euu _____________etc
//according to the pattern
                                                                             //a , e , i ,o, u
                                                                             //1 , 1 , 1 ,1, 1
                                                                             //5,  4  , 3, 2, 1
                                                                             //15, 10, 6,  3, 1
//hence total = 35

//T.C =  ~~O(n)
//S.C = O(n)//using extra space to create a vector but as we are using constant space so we can say that s.c is constant

class Solution {
public:
    int countVowelStrings(int n) {
        vector<int>res(5,1);
    
        for(int i = 2; i<=n; i++)
        {
            for(int i = 3; i>=0; i--)
            {
                res[i] += res[i+1];
            }
        }
        int ans = 0;
        for(auto it : res){
            ans += it;
        }
        return ans;
    }
};