class Solution {
public:
    int maxProfit(vector<int>& prices) { int profit = 0; for (int day = 1; day < (int)prices.size(); ++day) profit += max(0, prices[day] - prices[day - 1]); return profit; }
};
