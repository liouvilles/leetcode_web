class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var best = 0
        while (left < right) {
            best = maxOf(best, (right - left) * minOf(height[left], height[right]))
            if (height[left] <= height[right]) left++ else right--
        }
        return best
    }
}
