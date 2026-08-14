class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int hold = -prices[0], sold = 0, rest = 0;
        for (int day = 1; day < (int)prices.size(); ++day) {
            int oldHold = hold, oldSold = sold, oldRest = rest;
            hold = max(oldHold, oldRest - prices[day]);
            sold = oldHold + prices[day];
            rest = max(oldRest, oldSold);
        }
        return max(sold, rest);
    }
};
