Approach- 
    1. create two temporary strings
    2. For string s, 
        iterate over it and check when it encounters hash, 
        if temp1 is empty, copy hash into temp1, and increment count
        if temp1 is not empty, erase last character fro temp1, and decrement count.
    3. Repeat step 2 with string t and temp2
    4. compare temp1 and temp2
        a. return true if they are equal
        b. else return false
            
Complexity- O(n)
    
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
