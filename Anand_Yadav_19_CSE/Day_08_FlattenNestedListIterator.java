// link: https://leetcode.com/problems/flatten-nested-list-iterator/
// 341. Flatten Nested List Iterator
// T:O(N) S:O(N)
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
    List<Integer> li = null;
    int i = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        li = new ArrayList<>();
        for(NestedInteger i : nestedList){
            flatten(i);
        }
        
        
    }
    private void flatten(NestedInteger nested) {
        if (nested.isInteger()) 
            li.add(nested.getInteger());
        else 
            for (NestedInteger nestedFromList : nested.getList()) {
                flatten(nestedFromList);
        }
    }
    @Override
    public Integer next() {
        return li.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i<li.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */