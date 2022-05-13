#include<vector>
vector<string>vc{
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"
} ; 
class Solution{
    
    
    
public:
    vector<string>findallcombo(string&s)
    {
        if(s.length()==0)
        {
            vector<string>p;
            p.push_back("");
            return p;
        }
        char ch=s[0];
        string z=s.substr(1);
        vector<string>p=findallcombo(z);
        string a=vc[ch-'0'];
        vector<string>finals;
        for(auto pq:a)
        {
            for(auto v:p)
            {
                finals.push_back(pq+v);
            }
        }
        return finals;
        
    }
    vector<string> letterCombinations(string digits) {
        if(digits.length()==0)
        {
            return {};
        }
        vector<string>finals=findallcombo(digits);
        return finals;
        
        
        
    }
};