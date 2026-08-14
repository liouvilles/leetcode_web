class Solution {
    fun sumNumbers(root: TreeNode?): Int { fun dfs(node: TreeNode?, prefix: Int): Int { if (node == null) return 0; val current = prefix * 10 + node.`val`; if (node.left == null && node.right == null) return current; return dfs(node.left, current) + dfs(node.right, current) }; return dfs(root, 0) }
}
