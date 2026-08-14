class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val visited = BooleanArray(amount + 1)
        val queue = java.util.ArrayDeque<Int>()
        queue.offer(0)
        visited[0] = true
        var used = 0
        while (queue.isNotEmpty()) {
            used++
            repeat(queue.size) {
                val current = queue.poll()
                for (coin in coins) {
                    val next = current + coin
                    if (next == amount) return used
                    if (next < amount && !visited[next]) {
                        visited[next] = true
                        queue.offer(next)
                    }
                }
            }
        }
        return -1
    }
}
