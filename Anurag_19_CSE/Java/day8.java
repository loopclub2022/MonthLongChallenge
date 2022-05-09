//Link For Problem: https://leetcode.com/problems/flatten-nested-list-iterator/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class day8 {

    /*
     * Solution is Self-Explanatory.
     * 
     * Take a List of Integers.
     * 
     * Just traverse through input nestedList.
     * If only a single integer is found then add it
     * to the List.
     * 
     * If Nested List of Integers is found then traverse through that list
     * and add all the integers one by one.
     * 
     * Keep a pointer for the next element.
     * 
     * TC:
     * 1. For Flatteing the input list : O(n)
     * 
     * 2. Next : O(1)
     * 
     * 3. hasNext: O(1)
     * 
     * SC: O(n)
     */

    class NestedIterator implements Iterator<Integer> {

        private List<Integer> al;
        private int pointer;
        private int size;

        public NestedIterator(List<NestedInteger> nestedList) {
            al = new ArrayList<>();

            for (NestedInteger ni : nestedList) {

                if (ni.isInteger())
                    al.add(ni.getInteger());

                else {
                    NestedIterator it = new NestedIterator(ni.getList());
                    al.addAll(it.al);
                }
            }

            this.pointer = 0;
            this.size = al.size();
        }

        @Override
        public Integer next() {
            return al.get(this.pointer++);
        }

        @Override
        public boolean hasNext() {
            return this.pointer < this.size;
        }
    }
}
