class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun dfs(node: TreeNode?) {
            if (node == null) return
            dfs(node.left)
            result.add(node.`val`)
            dfs(node.right)
        }
        dfs(root)
        return result
    }
}
