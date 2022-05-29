/*
  Question - https://leetcode.com/problems/maximum-product-of-word-lengths/
  
  Time Complexity - O((n^2)*k)
  Space Complexity - O(n*k)
  n is number of words and k is letters in words
  
  Approach - We iterate over the given array, everytime we get a word, we store all of its elements in a hashset
             Then one by one, for every next word we check the common character, present if any, and if not 
             then store their lengths product in max 
*/

class Solution
{
    public int maxProduct(String[] words) 
    {
        int n = words.length, i, j;
        int max = 0;
        for(i=0; i<n; i++) 
        {
            HashSet<Character> set = new HashSet<>();
            for(j=0; j<words[i].length(); j++) 
            { 
                set.add(words[i].charAt(j));
            }
            for(int pos=i+1; pos<n; pos++) 
            {
                for(j = 0;j<words[pos].length();j++)
                {
                    if(set.contains(words[pos].charAt(j)))
                        break;
                }
                if(j==words[pos].length())  
                    max = Math.max(max,words[pos].length()*words[i].length());
            }
        }
        return max;
    }
}
