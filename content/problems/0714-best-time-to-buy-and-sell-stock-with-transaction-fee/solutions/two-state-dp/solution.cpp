class Solution {
    public: int maxProfit(vector<int>& prices,int fee){
        int cash=0,hold=-prices[0];
        for(int i=1;i<(int)prices.size();++i){
            int oldCash=cash;
            cash=max(cash,hold+prices[i]-fee);
            hold=max(hold,oldCash-prices[i]);
        }
        return cash;
    }
};
