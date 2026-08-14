class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], best = 0;
        for (int price : prices) {
            best = Math.max(best, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return best;
    }
}
