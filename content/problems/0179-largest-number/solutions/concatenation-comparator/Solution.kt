class Solution {
    fun largestNumber(nums: IntArray): String {
        val values = nums.map(Int::toString).sortedWith(Comparator { first, second -> (second + first).compareTo(first + second) })
        return if (values[0] == "0") "0" else values.joinToString("")
    }
}
