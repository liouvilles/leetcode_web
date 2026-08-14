class Solution {
    fun singleNumber(nums: IntArray): Int { var ones = 0; var twos = 0; for (value in nums) { ones = (ones xor value) and twos.inv(); twos = (twos xor value) and ones.inv() }; return ones }
}
