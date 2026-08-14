class Solution {
    fun getSum(first: Int, second: Int): Int { var a = first; var b = second; while (b != 0) { val carry = (a and b) shl 1; a = a xor b; b = carry }; return a }
}
