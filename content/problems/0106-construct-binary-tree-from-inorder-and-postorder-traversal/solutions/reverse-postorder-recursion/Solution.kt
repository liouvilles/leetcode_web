class Solution {
    private var postIndex = 0; private lateinit var positions: Map<Int, Int>
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? { positions = inorder.withIndex().associate { it.value to it.index }; postIndex = postorder.lastIndex; fun build(left: Int, right: Int): TreeNode? { if (left > right) return null; val value = postorder[postIndex--]; val middle = positions[value]!!; val root = TreeNode(value); root.right = build(middle + 1, right); root.left = build(left, middle - 1); return root }; return build(0, inorder.lastIndex) }
}
