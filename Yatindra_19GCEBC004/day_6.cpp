//Time Complexity:O(N)
class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack <pair<char,int>> char_with_freq;
        int len=s.length();
        char letter;
        pair <char,int> char_freq;
        for(int i=0;i<len;i++){
            letter=s[i];
            if(i==0 || char_with_freq.empty()){
                char_freq=make_pair(letter,1);
                char_with_freq.push(char_freq);
            }
            else{
                if(letter==char_with_freq.top().first){
                    char_with_freq.top().second++;
                    if(char_with_freq.top().second==k){
                        char_with_freq.pop();
                    }
                }
                else{
                    char_freq=make_pair(letter,1);
                    char_with_freq.push(char_freq);
                }
            }
        }
        string ans="";
        while(!char_with_freq.empty()){
            for(int i=0;i<char_with_freq.top().second;i++){
                ans+=char_with_freq.top().first;
            }
            char_with_freq.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};
