class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0; var right = x; var answer = 0
        while (left <= right) { val middle = left + (right - left) / 2; if (middle.toLong() * middle <= x) { answer = middle; left = middle + 1 } else right = middle - 1 }
        return answer
    }
}
