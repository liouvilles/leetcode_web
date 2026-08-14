class Solution {
    fun reverse(input: Int): Int {
        var x = input; var answer = 0L
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10 }
        return if (answer < Int.MIN_VALUE || answer > Int.MAX_VALUE) 0 else answer.toInt()
    }
}
