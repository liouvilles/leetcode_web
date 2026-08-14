class Solution {
    private var answer = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int { answer = Int.MIN_VALUE; gain(root); return answer }
    private fun gain(node: TreeNode?): Int { node ?: return 0; val left = maxOf(0, gain(node.left)); val right = maxOf(0, gain(node.right)); answer = maxOf(answer, node.`val` + left + right); return node.`val` + maxOf(left, right) }
}
