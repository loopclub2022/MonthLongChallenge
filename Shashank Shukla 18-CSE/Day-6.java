/*
Time Complexity: O(N)
Space Complexity: O(N)
Approach: Using single stack store the character and it's count as a pair in a stack and as count becomes equal to k remove the character.
*/

class Pair{
    char val;
    int count;
    public Pair(char c, int v){
        this.val = c;
        this.count = v;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(st.isEmpty())
                st.push(new Pair(s.charAt(i), 1));
            else{
                Pair cur = st.peek();
                if(cur.val != s.charAt(i)){
                    st.push(new Pair(s.charAt(i), 1));
                } else {
                    int ctr = cur.count;
                    if(ctr+1 == k)
                        st.pop();
                    else 
                        cur.count = ctr + 1;
                }
            }
            
        }
        String res="";
        while(!st.isEmpty()){
            Pair ans = st.pop();
            while(ans.count-- > 0)
                res = ans.val + res;
        }
        return res;
    }
}
