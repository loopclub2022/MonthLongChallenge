class Solution {
    int arr[9]={1,2,3,4,5,6,7,8,9};
public:
    void findcombo(vector<vector<int>>&vc,vector<int>v,int c,int sum,int n,int k,int i)
    {
        if(i==9 and c==k and sum==n)
        {
            vc.push_back(v);
            return;
            
        }
        if(i==9)
        {
            return;
        }
        
        if(c>k or sum>n)
        {
            return;
        }
        if(c==k and sum==n)
        {
            vc.push_back(v);
            return;
        }
        v.push_back(arr[i]);
        
        findcombo(vc,v,c+1,sum+arr[i],n,k,i+1);
        v.pop_back();
        findcombo(vc,v,c,sum,n,k,i+1);
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>>vc;
        vector<int>v;
        
        
        findcombo(vc,v,0,0,n,k,0);
        return vc;
        
    }
};