class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = java.util.ArrayDeque<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            repeat(queue.size) {
                val node = queue.poll()
                level.add(node.`val`)
                node.left?.let(queue::offer)
                node.right?.let(queue::offer)
            }
            result.add(level)
        }
        return result
    }
}
