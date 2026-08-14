class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int { val counts = HashMap<Long, Int>(); counts[0L] = 1; return visit(root, 0L, targetSum.toLong(), counts) }
    private fun visit(node: TreeNode?, prefix: Long, target: Long, counts: MutableMap<Long, Int>): Int {
        node ?: return 0
        val current = prefix + node.`val`; var answer = counts[current - target] ?: 0; counts[current] = (counts[current] ?: 0) + 1
        answer += visit(node.left, current, target, counts) + visit(node.right, current, target, counts)
        counts[current] = counts.getValue(current) - 1; return answer
    }
}
