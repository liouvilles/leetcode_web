class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        var current = root
        while (current != null) {
            if (current.left == null) {
                result.add(current.`val`)
                current = current.right
            } else {
                var predecessor = current.left!!
                while (predecessor.right != null && predecessor.right !== current) {
                    predecessor = predecessor.right!!
                }
                if (predecessor.right == null) {
                    predecessor.right = current
                    current = current.left
                } else {
                    predecessor.right = null
                    result.add(current.`val`)
                    current = current.right
                }
            }
        }
        return result
    }
}
