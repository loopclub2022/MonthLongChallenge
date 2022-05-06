/* Question - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
   Time Complexity - O(n)
   Space Complexity -O(n)
   Approach - We start storing alphabets with their continuous count in the stack,
              For Example - "deeedbcccbbaa" and k = 3
              The stack to be formed is - | a, 2 |
                                          | b, 2 |
                                          | c, 3 |
                                          | b, 1 |
                                          | d, 1 |
                                          | e, 3 |
                                          | d, 1 |
                                           ------
              once the count is k, that alphabet is removed, and if continuous alphabets have same count they are summed up in one,
              and if they reach k they are removed as well.
              After removing alphabets with count 3, we will get
              
                           | a, 2 |
                           | d, 2 |
                            ------
                         Thus final_string is  "ddaa"
              At the end we get a stack with alphabets and their count that form the final String.
              Using StringBuilder which is faster than string we append the alphabets of stack to form the final string
              as our output.*/

class Solution {
    public String removeDuplicates(String s, int k) 
    {
        Stack<Pair> stack = new Stack<Pair>();
        if(s.length()<k)
            return s;
        int i = 0;
        for(;i<s.length();i++)
        {
            if(stack.isEmpty())
            {
                stack.push(new Pair(s.charAt(i),1));
            }
            else if(stack.peek().alphabet==s.charAt(i))
            {
                Pair p = stack.pop();
                p.count++;
                if(p.count!=k)
                    stack.push(p);
            }
            else
            {
                stack.push(new Pair(s.charAt(i),1));
            }
        }
        StringBuilder final_string = new StringBuilder();
        for(Pair p : stack)
        {
            for(i=1;i<=p.count;i++)
            {
                final_string.append(p.alphabet);
            }
        }
        return final_string.toString();
    }
}

class Pair
{
    public char alphabet;
    public int count;
    public Pair(char a, int c)
    {
        alphabet =a;
        count = c;
    }
}
