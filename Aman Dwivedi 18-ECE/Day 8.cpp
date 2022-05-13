https://leetcode.com/problems/flatten-nested-list-iterator/
Tine: O(N)
Space: O(N)

class NestedIterator {
    
    int curr=0; //for current position of original list
    vector<int> ansList; //for storing integers
public:
    
    void solve(vector<NestedInteger> &nestedList) //helper function
    {
        int n=nestedList.size();
        int ele;
        vector<NestedInteger> tempList; //for storing list
        
        //while iterating next element, it can be a integer or a integer list,
        //if it is a integer we take that value and push it to the ansList vector, else if a list of integers, we recursively call the helper function,
        //then the magic of recursion happens it solves that part individually. :p
        for(int i=0;i<n;i++)
        {
            if(nestedList[i].isInteger())
            {
                int ele=nestedList[i].getInteger();
                ansList.push_back(ele);   
            }
            else
            {
                tempList=nestedList[i].getList();
                solve(tempList); //recursion magic 
            }
        }
    }
    NestedIterator(vector<NestedInteger> &nestedList) {
        solve(nestedList); 
    }
    
    int next() {
        int ans=ansList[curr]; //simply returns the next element
        curr++;
        return ans;
    }
    
    bool hasNext() { //check if next element is present or not
        if(curr==ansList.size())
            return false;
        else
            return true;
    }
};
