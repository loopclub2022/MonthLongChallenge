 #include<bits/stdc++.h>
 using namespace std;
 bool backspacecompare(string s, string t){
     int skipS=0, skipT=0;
     int i=s.size();
     int j=t.size();
 while(i>=0 || j>=0){
      while(i>=0){
          if(s[i]=='#'){
              skipS++;
              i--;
          }
          else if(skipS>0){
             skipS--;
             i--;
          }
          else{
              break;
          }
      }
      while(j>=0){
          if(t[j]=='#'){
              skipT++;
              j--;
          }
          else if(skipT>0){
             skipT--;
             j--;
          }
          else{
              break;
          }
      }
       
       if(i>=0 && j>=0 && s[i]!=t[j])
          return false;
        else if((i>=0)!=(j>=0))
             return false;
        i--;
        j--;
}
 return true;  
 }
        
 int main(){
 string s, t;
 cin>>s>>t;
 cout<<backspacecompare(s,t);
 

}
