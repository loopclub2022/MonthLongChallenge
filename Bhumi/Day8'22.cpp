//You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

// Implement the NestedIterator class:

// NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
// int next() Returns the next integer in the nested list.
// boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
// Your code will be tested with the following pseudocode:

// initialize iterator with nestedList
// res = []
// while iterator.hasNext()
//     append iterator.next() to the end of res
// return res
// If res matches the expected flattened list, then your code will be judged as correct.


//explaination of Question :
// we've given a nested list of integers 
//It can have 2 cases : --
//1 . Integers
//2. having more lists inside a given list
// Eg :  [[1,1],2,[1,1]]
// so here we've to output the element of list as [1,1,2,1,1]
// and to complete all three functions ..like nested list first check all ele and lists, then if next is also a list then we again call the fun and perform oprn as prev
//in next if we've found list contating ele we'll inc its count
//we've to return if all elements of given list  matches with out list which we've stored in vec

///Approach --> Here approach is First  to check the elements or to check the nested lists we'll use loop to traverse the nested list
//if nested list contain integer ( we'll check this using stl fun **isInteger()** then we'll store this into vec else recursively call the checkData fnction again
//in next we'lll just inc the count to store each ele at each index
//the in return part we'll check that using cnt
//if cnt < vec.size ---> return false else return true
 

 /**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */

class NestedIterator {
public:
    vector<int>vec;
    int cnt = 0;
  void checkData(vector<NestedInteger> &nestedList) {
       for(int i =0; i< nestedList.size(); i++){
           if(nestedList[i].isInteger()){
               vec.push_back(nestedList[i].getInteger());
               
           }
           else{
               checkData(nestedList[i].getList());
           }
       }  
       }   
       
    NestedIterator(vector<NestedInteger> &nestedList) {
        checkData(nestedList);
    cnt= 0;
          }
    int next() {
        
        return vec[cnt++];
    }
    
    bool hasNext() {
        if(cnt < vec.size()) return true;
        else return false;
    }
};

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i(nestedList);
 * while (i.hasNext()) cout << i.next();
 */