class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> { val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>(); fun dfs(node: TreeNode?, remaining: Long) { if (node == null) return; path.add(node.`val`); if (node.left == null && node.right == null && remaining == node.`val`.toLong()) answer.add(path.toList()) else { dfs(node.left, remaining - node.`val`); dfs(node.right, remaining - node.`val`) }; path.removeAt(path.lastIndex) }; dfs(root, targetSum.toLong()); return answer }
}
