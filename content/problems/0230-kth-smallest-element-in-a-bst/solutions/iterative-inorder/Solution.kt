class Solution {
    fun kthSmallest(root: TreeNode?, inputK: Int): Int {
        val stack: ArrayDeque<TreeNode> = ArrayDeque(); var node = root; var k = inputK
        while (true) { while (node != null) { stack.addLast(node); node = node.left }; node = stack.removeLast(); if (--k == 0) return node.`val`; node = node.right }
    }
}
