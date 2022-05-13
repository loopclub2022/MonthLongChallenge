/*  Question - https://leetcode.com/problems/flatten-nested-list-iterator/submissions/
    
    
    For NestedIterator object creation
       Time Complexity - O(n)   Space Complexity - O(n) 
    For next() and hasnext()   
       Time Complexity - O(1)
       
    Approach - To convert the nestedlist in simple list we are using a function gestsList 
               that basically uses recursion to iterate over every list it gets, and when a integer is found
               it is added to the main list.
*/



/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int pos = 0;
    List<Integer> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        getsList(nestedList);
    }

    @Override
    public Integer next() {
        pos++;
        return list.get(pos-1);
    }

    @Override
    public boolean hasNext() {
        if(pos<list.size())
            return true;
        return false;
    }
    
    public void getsList(List<NestedInteger> nested)
    {
        for(int i = 0;i<nested.size();i++)
        {
            if(nested.get(i).getInteger()!=null)
            {
                list.add(nested.get(i).getInteger());
                continue;
            }
            getsList(nested.get(i).getList());
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
