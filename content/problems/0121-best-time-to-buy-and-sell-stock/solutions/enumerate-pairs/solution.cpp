class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int best = 0;
        for (int buy = 0; buy < (int)prices.size(); ++buy)
            for (int sell = buy + 1; sell < (int)prices.size(); ++sell)
                best = max(best, prices[sell] - prices[buy]);
        return best;
    }
};
