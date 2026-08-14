class Solution {
    fun reverseBits(input: Int): Int {
        var value = input; var answer = 0
        repeat(32) { answer = (answer shl 1) or (value and 1); value = value ushr 1 }
        return answer
    }
}
