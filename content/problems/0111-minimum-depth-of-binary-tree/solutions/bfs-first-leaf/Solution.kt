class Solution {
    fun minDepth(root: TreeNode?): Int { if (root == null) return 0; val queue = ArrayDeque<TreeNode>(); queue.add(root); var depth = 0; while (queue.isNotEmpty()) { depth++; repeat(queue.size) { val node = queue.removeFirst(); if (node.left == null && node.right == null) return depth; node.left?.let { queue.add(it) }; node.right?.let { queue.add(it) } } }; return depth }
}
