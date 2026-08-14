class MinStack {
    private val stack = ArrayDeque<IntArray>()
    fun push(value: Int) { val minimum = if (stack.isEmpty()) value else minOf(value, stack.last()[1]); stack.addLast(intArrayOf(value, minimum)) }
    fun pop() { stack.removeLast() }
    fun top(): Int = stack.last()[0]
    fun getMin(): Int = stack.last()[1]
}
