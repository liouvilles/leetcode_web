class Solution {
    public: int getMaximumConsecutive(vector<int>& coins){
        sort(coins.begin(),coins.end());
        int reachable=0;
        for(int coin:coins){
            if(coin>reachable+1)break;
            reachable+=coin;
        }
        return reachable+1;
    }
};
