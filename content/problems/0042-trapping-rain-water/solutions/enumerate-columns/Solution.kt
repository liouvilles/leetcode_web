class Solution {
    fun trap(height: IntArray): Int {
        var water = 0
        for (i in 1 until height.lastIndex) {
            var leftMax = 0
            var rightMax = 0
            for (left in 0..i) leftMax = maxOf(leftMax, height[left])
            for (right in i..height.lastIndex) rightMax = maxOf(rightMax, height[right])
            water += minOf(leftMax, rightMax) - height[i]
        }
        return water
    }
}
