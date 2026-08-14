class Solution {
    fun trailingZeroes(input: Int): Int { var n = input; var answer = 0; while (n > 0) { n /= 5; answer += n }; return answer }
}
