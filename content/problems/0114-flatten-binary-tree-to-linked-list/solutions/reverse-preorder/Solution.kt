class Solution {
    private var previous: TreeNode? = null
    fun flatten(root: TreeNode?) { if (root == null) return; flatten(root.right); flatten(root.left); root.right = previous; root.left = null; previous = root }
}
