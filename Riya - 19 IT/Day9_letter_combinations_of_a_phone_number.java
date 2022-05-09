/* Question - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
   
   Time Complexity - O(n^k)
   Space Complexity - O(n^k)  where n is length of digits and k is 3 or 4 depending on the length of string a digit holds
   Approach - We use king of BFS where for a given string, for example - "235", we calculate the respective combinations for 35,
              then the vallues associated with 2 i.e "abc" are traversed and a+ list then b + list and so on 
              is added to the final list to return.
   */

class Solution {
    
    String[] value = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> output1 = new LinkedList<String>();
        List<String> output2 = new LinkedList<String>();
        if(digits.length()==0)
            return output2;
        if(digits.length()==1)
        {
            for(int j = 0;j<value[Integer.parseInt(digits.charAt(0)+"")].length(); j++)
            {
                output2.add(""+value[Integer.parseInt(digits.charAt(0)+"")].charAt(j));
            }
            return output2;
        }
        output1 = letterCombinations(digits.substring(1));
        for(int i = 0;i<value[Integer.parseInt(digits.charAt(0)+"")].length();i++)
        {
            for(String a : output1)
            {
                output2.add(value[Integer.parseInt(digits.charAt(0)+"")].charAt(i)+a);
            }
        }
        return output2;
    }
}
