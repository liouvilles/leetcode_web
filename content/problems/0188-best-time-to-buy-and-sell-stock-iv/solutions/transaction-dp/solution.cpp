class Solution {
    public: int maxProfit(int k,vector<int>& prices){
        if(k>=(int)prices.size()/2){
            int p=0;
            for(int i=1;i<(int)prices.size();++i)p+=max(0,prices[i]-prices[i-1]);
            return p;
        }
        vector<int> buy(k+1,INT_MIN/2),sell(k+1);
        for(int price:prices)for(int t=1;t<=k;++t){
            buy[t]=max(buy[t],sell[t-1]-price);
            sell[t]=max(sell[t],buy[t]+price);
        }
        return sell[k];
    }
};
