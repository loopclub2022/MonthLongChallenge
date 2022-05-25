/*
   Question - https://leetcode.com/problems/longest-valid-parentheses/
*/


// Approach 1 - Here string is used as a stack and is stored with the index in the map, for future reference to calculate valid parenthesis
// Time Complexity - O(n * longest)
//  Space Complexity - O(n) 

class Solution {
    public int longestValidParentheses(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder stack = new StringBuilder(s.length());
        int longest = 0;
        map.put(stack.toString(),-1);
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c=='(' || stack.length()==0  ||  (stack.charAt(stack.length()-1)!='(' ) )
            {
                stack.append(c);
                map.put(stack.toString(),i);
            }
            else
                stack.deleteCharAt(stack.length()-1);
            if(map.containsKey(stack.toString()))
                longest = Math.max(longest,i-map.get(stack.toString()));
        }
        return longest;
    }
}

//Approach 2 - Like earlier, instead of storing the index as well as the string , 
//                here we are storing index directly in stack.
// Time Complexity - O(n)
// Space Complexity - O(n)


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int longest = 0;
        stack.push(-1);
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c=='(' )
                stack.push(i);
            else
            {
                stack.pop();
                if(stack.size()==0)
                    stack.push(i);
                else
                    longest = Math.max(longest, i-stack.peek());
            }
        }
        return longest;
    }   
}
