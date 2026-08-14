class Solution {
    fun climbStairs(n: Int): Int {
        var result = longArrayOf(1, 0, 0, 1)
        var base = longArrayOf(1, 1, 1, 0)
        var power = n
        while (power > 0) {
            if (power and 1 == 1) result = multiply(result, base)
            base = multiply(base, base)
            power = power shr 1
        }
        return result[0].toInt()
    }

    private fun multiply(a: LongArray, b: LongArray) = longArrayOf(
        a[0] * b[0] + a[1] * b[2], a[0] * b[1] + a[1] * b[3],
        a[2] * b[0] + a[3] * b[2], a[2] * b[1] + a[3] * b[3]
    )
}
