class Solution {
    fun addBinary(a: String, b: String): String {
        val answer = StringBuilder(); var left = a.lastIndex; var right = b.lastIndex; var carry = 0
        while (left >= 0 || right >= 0 || carry != 0) { var sum = carry; if (left >= 0) sum += a[left--] - '0'; if (right >= 0) sum += b[right--] - '0'; answer.append(sum and 1); carry = sum shr 1 }
        return answer.reverse().toString()
    }
}
