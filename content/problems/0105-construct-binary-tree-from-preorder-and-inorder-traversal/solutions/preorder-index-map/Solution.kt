class Solution {
    private var preorderIndex = 0
    private lateinit var preorderValues: IntArray
    private lateinit var inorderIndex: Map<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        preorderValues = preorder
        preorderIndex = 0
        inorderIndex = inorder.withIndex().associate { it.value to it.index }
        return build(0, inorder.lastIndex)
    }

    private fun build(left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val value = preorderValues[preorderIndex++]
        val root = TreeNode(value)
        val middle = inorderIndex.getValue(value)
        root.left = build(left, middle - 1)
        root.right = build(middle + 1, right)
        return root
    }
}
