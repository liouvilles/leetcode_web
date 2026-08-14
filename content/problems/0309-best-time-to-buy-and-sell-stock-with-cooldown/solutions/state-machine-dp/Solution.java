class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0], sold = 0, rest = 0;
        for (int day = 1; day < prices.length; day++) {
            int oldHold = hold, oldSold = sold, oldRest = rest;
            hold = Math.max(oldHold, oldRest - prices[day]);
            sold = oldHold + prices[day];
            rest = Math.max(oldRest, oldSold);
        }
        return Math.max(sold, rest);
    }
}
