class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val queue = java.util.ArrayDeque<TreeNode>()
        queue.offer(root)
        var depth = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val node = queue.poll()
                node.left?.let(queue::offer)
                node.right?.let(queue::offer)
            }
            depth++
        }
        return depth
    }
}
