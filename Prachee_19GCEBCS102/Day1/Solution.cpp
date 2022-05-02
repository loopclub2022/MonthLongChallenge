class Solution {
public:
    bool backspaceCompare(string s, string t) {
        int i, j; int c1=0; int c2=0;
        string temp1=""; string temp2="";
        for(i=0; s[i]!='\0'; i++){
            if(s[i]=='#'){
                if(c1!=0){
                    temp1.erase(c1-1);
                c1--; 
                }
               
            }
            else{
                temp1+= s[i];
                c1++;
            }       
        }
        for(j=0; t[j]!='\0'; j++){
             if(t[j]=='#'){
                if(c2!=0){
                    temp2.erase(c2-1);
                    c2--;   
                }
            }
            else{
                  temp2+= t[j];
            c2++;
            }
          
           
        }
        int x= temp1.compare(temp2);
        if (x != 0) return false;
        else return true;
    }
};
