class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null) return root.`val` == targetSum
        val remaining = targetSum - root.`val`
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining)
    }
}
