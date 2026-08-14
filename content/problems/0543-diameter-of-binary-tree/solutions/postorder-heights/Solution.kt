class Solution {
    private var diameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int { diameter = 0; height(root); return diameter }
    private fun height(node: TreeNode?): Int { node ?: return 0; val left = height(node.left); val right = height(node.right); diameter = maxOf(diameter, left + right); return maxOf(left, right) + 1 }
}
