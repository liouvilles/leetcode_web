class Solution {
    public: int minWastedSpace(vector<int>& packages,vector<vector<int>>& boxes){
        sort(packages.begin(),packages.end());
        vector<long long> prefix(packages.size()+1);
        for(int i=0;i<(int)packages.size();++i)prefix[i+1]=prefix[i]+packages[i];
        long long best=LLONG_MAX;
        for(auto& supplier:boxes){
            sort(supplier.begin(),supplier.end());
            if(supplier.back()<packages.back())continue;
            int index=0;
            long long waste=0;
            for(int box:supplier){
                int next=upper_bound(packages.begin(),packages.end(),box)-packages.begin();
                if(next>index){
                    waste+=1LL*box*(next-index)-(prefix[next]-prefix[index]);
                    index=next;
                }
                if(index==(int)packages.size())break;
            }
            best=min(best,waste);
        }
        return best==LLONG_MAX?-1:best%1000000007;
    }
};
