class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> { if (root == null) return emptyList(); val answer = mutableListOf<Int>(); val stack = ArrayDeque<TreeNode>(); stack.addLast(root); while (stack.isNotEmpty()) { val node = stack.removeLast(); answer.add(node.`val`); node.left?.let { stack.addLast(it) }; node.right?.let { stack.addLast(it) } }; answer.reverse(); return answer }
}
