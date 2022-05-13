/*
Time Complexity: O(N)
approach: all the characters corresponding to their number keys are mapped and then all the combinations are formed and added to the list.
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.equals("")) return res;
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        StringBuilder s=new StringBuilder();
        formList(digits, map, s, res);       
        return res;
    }
    private void formList(String d, Map<Character, char[]> map, StringBuilder s, List<String> res) {
        if(s.length() == d.length()){
            res.add(s.toString());
            return;
        }
        for(char c: map.get(d.charAt(s.length()))){
            s.append(c);
            formList(d, map, s, res);
            s.deleteCharAt(s.length()-1);
        }
    }
}
