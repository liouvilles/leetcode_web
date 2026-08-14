class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val answer = ArrayList<Int>(); val queue: ArrayDeque<TreeNode> = ArrayDeque(); queue.add(root)
        while (queue.isNotEmpty()) { val size = queue.size; repeat(size) { index -> val node = queue.removeFirst(); if (index == size - 1) answer.add(node.`val`); node.left?.let(queue::add); node.right?.let(queue::add) } }
        return answer
    }
}
