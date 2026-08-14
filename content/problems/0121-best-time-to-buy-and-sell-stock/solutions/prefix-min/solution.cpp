class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = prices[0], best = 0;
        for (int price : prices) {
            best = max(best, price - minPrice);
            minPrice = min(minPrice, price);
        }
        return best;
    }
};
