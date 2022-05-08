/*
approach: used iterator to iterate through the main list, if it encounters an element then it is directly added to the result list,
          else recursive call is made to iterate through the nested list. 
*/
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> resList = null;
    private Iterator<Integer> i;
    public NestedIterator(List<NestedInteger> nestedList) {
        resList = new ArrayList<>();
        flat(nestedList);
        i = resList.iterator();
    }
    
    private void flat(List<NestedInteger> nestedList){
        for(NestedInteger curr: nestedList){
            if(curr.isInteger()){
                resList.add(curr.getInteger());
            } else {
                flat(curr.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(i.hasNext())
            return i.next();
        else 
            return null;
    }

    @Override
    public boolean hasNext() {
        return i.hasNext();
    }
}
