// My code will be here T = O(N), S = O(N)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Integer> ss = new Stack<>();
        Stack<Integer> tt = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) != '#')
                ss.push((int)s.charAt(i));
            else{
                if(!ss.isEmpty())
                    ss.pop();
            }
        }
        for(int i = 0; i<t.length(); i++){
            if(t.charAt(i) != '#')
                tt.push((int)t.charAt(i));
            else {
                if(!tt.isEmpty())
                    tt.pop();
            }
        }
        if(ss.size() != tt.size())
            return false;
        while(!ss.isEmpty()){
            if(ss.peek() != tt.peek())
                return false;
            ss.pop();
            tt.pop();
        }
        return true;
    }
}
