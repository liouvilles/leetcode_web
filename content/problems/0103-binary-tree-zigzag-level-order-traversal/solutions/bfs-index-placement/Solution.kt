class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList(); val answer = mutableListOf<List<Int>>(); val queue = ArrayDeque<TreeNode>(); queue.add(root); var leftToRight = true
        while (queue.isNotEmpty()) { val size = queue.size; val level = MutableList(size) { 0 }; repeat(size) { index -> val node = queue.removeFirst(); level[if (leftToRight) index else size - 1 - index] = node.`val`; node.left?.let { queue.add(it) }; node.right?.let { queue.add(it) } }; answer.add(level); leftToRight = !leftToRight }
        return answer
    }
}
