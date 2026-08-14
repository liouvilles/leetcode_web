class Solution {
    fun trap(height: IntArray): Int {
        val leftMax = IntArray(height.size)
        val rightMax = IntArray(height.size)
        leftMax[0] = height[0]
        for (i in 1 until height.size) leftMax[i] = maxOf(leftMax[i - 1], height[i])
        rightMax[height.lastIndex] = height.last()
        for (i in height.lastIndex - 1 downTo 0) rightMax[i] = maxOf(rightMax[i + 1], height[i])
        var water = 0
        for (i in height.indices) water += minOf(leftMax[i], rightMax[i]) - height[i]
        return water
    }
}
