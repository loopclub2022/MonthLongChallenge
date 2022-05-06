#include<bits/stdc++.h>
using namespace std;

class Solution {                     ///s =xywrrmp    t= xywrrmu#p
public:
    bool backspaceCompare(string s, string t) {
       string x="",y = "";
       int n =s.size(),m = t.size();

       for(int i =0;i<n;i++)
       {
         if(s[i]!='#')
         {
           x+=s[i];                   //xywrrmp
         }
         else if(!x.empty()&&s[i]=='#')
         {
           x.pop_back();
         }

       }
       for(int i =0;i<m;i++)
       {
         if(t[i]!='#')
         {
           y+=t[i];                    //xywrrmp
         }
         else if(!y.empty()&&t[i]=='#')
         {
           y.pop_back();
         }

       }
       return (x==y);

  }
};