//Link For Problem : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

import java.util.Stack;

public class day6 {

    /*
     * Use Two Stacks.
     * 
     * First Stack to store the
     * valid characters.
     * 
     * Second Stack to store the
     * count of characters at each step.
     * 
     * If Repetetive characters are found then
     * increase the count by 1.
     * 
     * If count=k then pop k elements from the
     * character stack.
     * 
     * Finally Add all the characters to a String and
     * reverse it.
     * 
     * TC: O(nk)
     * 
     * SC: O(n) + O(n) = 2O(n) => O(n)
     */

    public String removeDuplicates(String s, int k) {
        Stack<Character> chars = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (chars.size() > 0 && chars.peek() == ch)
                count.push(count.peek() + 1);
            else
                count.push(1);

            chars.push(ch);

            if (count.peek() == k) {
                for (int i = 0; i < k; i++) {
                    chars.pop();
                    count.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty())
            sb.append(chars.pop());

        return sb.reverse().toString();
    }

    /*
     * In This Approach, Just Use a count array of length s.
     * 
     * Keep the count of each character in the array.
     * If count=k, then delete k characters from the end.
     * 
     * TC : O(n)
     * 
     * SC: O(n)
     */

    public String optimized(String s, int k) {
        int arr[] = new int[s.length()];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);
            int current = sb.length() - 1;

            if (current > 0 && sb.charAt(current) == sb.charAt(current - 1))
                arr[current] = arr[current - 1] + 1;
            else
                arr[current] = 1;

            if (arr[current] == k)
                sb.delete(sb.length() - k, sb.length());
        }

        return sb.toString();
    }
}
