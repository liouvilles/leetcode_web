class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack: ArrayDeque<Int> = ArrayDeque()
        stack.addLast(-1)
        var best = 0
        for (index in 0..heights.size) {
            val height = if (index == heights.size) 0 else heights[index]
            while (stack.last() != -1 && heights[stack.last()] > height) { val rectangleHeight = heights[stack.removeLast()]; best = maxOf(best, rectangleHeight * (index - stack.last() - 1)) }
            stack.addLast(index)
        }
        return best
    }
}
