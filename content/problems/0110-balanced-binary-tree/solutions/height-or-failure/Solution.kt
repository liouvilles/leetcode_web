class Solution {
    fun isBalanced(root: TreeNode?): Boolean = height(root) >= 0
    private fun height(node: TreeNode?): Int {
        node ?: return 0
        val left = height(node.left); if (left < 0) return -1
        val right = height(node.right); if (right < 0 || kotlin.math.abs(left - right) > 1) return -1
        return maxOf(left, right) + 1
    }
}
