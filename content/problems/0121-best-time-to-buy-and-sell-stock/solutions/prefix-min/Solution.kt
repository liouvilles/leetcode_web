class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = prices[0]
        var best = 0
        for (price in prices) {
            best = maxOf(best, price - minPrice)
            minPrice = minOf(minPrice, price)
        }
        return best
    }
}
