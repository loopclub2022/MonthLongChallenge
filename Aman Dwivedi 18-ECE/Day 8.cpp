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
        vector<NestedInteger> tempList; //fir storing list
        //while iterating next element can be a integer or a integer list, if integer we take that value ans push it to ans vector, else we recursively call the helper function
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
                solve(tempList);
            }
        }
    }
    NestedIterator(vector<NestedInteger> &nestedList) {
        solve(nestedList);
    }
    
    int next() {
        int ans=ansList[curr]; //check if next element is present or not
        curr++;
        return ans;
    }
    
    bool hasNext() { //check for end
        if(curr==ansList.size())
            return false;
        else
            return true;
    }
};
