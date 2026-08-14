class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var leftMax = 0
        var rightMax = 0
        var water = 0
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = maxOf(leftMax, height[left])
                water += leftMax - height[left++]
            } else {
                rightMax = maxOf(rightMax, height[right])
                water += rightMax - height[right--]
            }
        }
        return water
    }
}
