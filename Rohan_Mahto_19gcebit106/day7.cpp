class NestedIterator {
     vector<int>finals;
    int p=0;
public:
    
    void findnested(vector<NestedInteger> &nestedList)
    {
        for(int i=0;i<nestedList.size();i++)
        {
            if(nestedList[i].isInteger())
            {
                finals.push_back(nestedList[i].getInteger());
            }
            else
            {
                findnested(nestedList[i].getList());
            }
        }
    }
    NestedIterator(vector<NestedInteger> &nestedList) {
       
        findnested(nestedList);
        
    }
    
    int next() {
        return finals[p++];
        
    }
    
    bool hasNext() {
        return p<finals.size();
        
    }
};
