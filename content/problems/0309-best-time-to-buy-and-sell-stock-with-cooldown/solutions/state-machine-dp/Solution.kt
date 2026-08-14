class Solution {
    fun maxProfit(prices: IntArray): Int {
        var hold = -prices[0]
        var sold = 0
        var rest = 0
        for (day in 1 until prices.size) {
            val oldHold = hold
            val oldSold = sold
            val oldRest = rest
            hold = maxOf(oldHold, oldRest - prices[day])
            sold = oldHold + prices[day]
            rest = maxOf(oldRest, oldSold)
        }
        return maxOf(sold, rest)
    }
}
