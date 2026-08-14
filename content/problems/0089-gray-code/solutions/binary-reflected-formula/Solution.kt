class Solution {
    fun grayCode(n: Int): List<Int> { val answer = mutableListOf<Int>(); for (value in 0 until (1 shl n)) answer.add(value xor (value shr 1)); return answer }
}
