class Solution {
    fun countBits(n: Int): IntArray { val bits = IntArray(n + 1); for (value in 1..n) bits[value] = bits[value shr 1] + (value and 1); return bits }
}
