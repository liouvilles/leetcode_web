class Solution {
    fun isSymmetric(root: TreeNode?): Boolean = root == null || mirror(root.left, root.right)

    private fun mirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) return left === right
        return left.`val` == right.`val`
            && mirror(left.left, right.right)
            && mirror(left.right, right.left)
    }
}
