class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size); val stack: ArrayDeque<Int> = ArrayDeque()
        for (day in temperatures.indices) { while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[day]) { val previous = stack.removeLast(); answer[previous] = day - previous }; stack.addLast(day) }
        return answer
    }
}
