/* Question - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
   Time Complexity - O(n) - For both approaches
   Space Complexity -O(n) - For both Approaches
   Approach 1 - We start storing alphabets with their continuous count in the stack,
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

// APPROACH 1
class Solution1 {
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

/* APPROACH 2 - Instead of maintaining a stack with count and alphabets, we nstead manage a array of count
                Here with each index count, we also maintain an overall_count that we decrease by k, instead of 
                removing the pair from the array(stack) like earlier. */

class Solution2 {
    public String removeDuplicates(String str, int k) {
        int s = 0;
        int[] count = new int[str.length()];
        char[] word = str.toCharArray();
        for (int i = 0; i < word.length; i++) {
            word[s] = word[i];
            count[s] = (s > 0 && word[i] == word[s-1] ) ? count[s-1]+1 : 1;
            if (count[s] == k) s-= k;
            s++;
        }
        return new String(word, 0, s);
    }
}
                
