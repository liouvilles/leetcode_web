class Solution {
    fun maxProfit(prices: IntArray): Int { var profit = 0; for (day in 1 until prices.size) profit += maxOf(0, prices[day] - prices[day - 1]); return profit }
}
