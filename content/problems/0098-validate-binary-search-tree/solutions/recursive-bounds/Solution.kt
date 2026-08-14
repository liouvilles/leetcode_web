class Solution {
    fun isValidBST(root: TreeNode?): Boolean = validate(root, Long.MIN_VALUE, Long.MAX_VALUE)

    private fun validate(node: TreeNode?, lower: Long, upper: Long): Boolean {
        node ?: return true
        val value = node.`val`.toLong()
        if (value <= lower || value >= upper) return false
        return validate(node.left, lower, value) && validate(node.right, value, upper)
    }
}
