class Solution {
    bool feasible(long long amount,int budget,vector<vector<int>>& composition,vector<int>& stock,vector<int>& cost){
        for(auto& recipe:composition){
            long long spent=0;
            for(int metal=0;metal<(int)stock.size();++metal){
                long long shortage=amount*recipe[metal]-stock[metal];
                if(shortage>0){
                    spent+=shortage*cost[metal];
                    if(spent>budget)break;
                }
            }
            if(spent<=budget)return true;
        }
        return false;
    }
    public:int maxNumberOfAlloys(int n,int k,int budget,vector<vector<int>>& composition,vector<int>& stock,vector<int>& cost){
        long long upper=0;
        for(auto& recipe:composition){
            long long machineUpper=LLONG_MAX;
            for(int metal=0;metal<n;++metal){
                long long individuallyAffordable=stock[metal]+1LL*budget/cost[metal];
                machineUpper=min(machineUpper,individuallyAffordable/recipe[metal]);
            }
            upper=max(upper,machineUpper);
        }
        long long low=0,high=upper+1;
        while(low+1<high){
            long long middle=(low+high)/2;
            if(feasible(middle,budget,composition,stock,cost))low=middle;
            else high=middle;
        }
        return low;
    }
};
