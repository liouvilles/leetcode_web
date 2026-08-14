class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val queue = java.util.ArrayDeque<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            node.left = node.right.also { node.right = node.left }
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
        return root
    }
}
