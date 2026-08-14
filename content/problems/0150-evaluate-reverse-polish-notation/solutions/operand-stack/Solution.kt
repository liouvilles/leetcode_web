class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) { if (token.length == 1 && token[0] in "+-*/") { val right = stack.removeLast(); val left = stack.removeLast(); stack.addLast(when (token) { "+" -> left + right; "-" -> left - right; "*" -> left * right; else -> left / right }) } else stack.addLast(token.toInt()) }
        return stack.last()
    }
}
