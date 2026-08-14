class Solution {
    public int maxProfit(int[] prices) { int profit = 0; for (int day = 1; day < prices.length; day++) profit += Math.max(0, prices[day] - prices[day - 1]); return profit; }
}
