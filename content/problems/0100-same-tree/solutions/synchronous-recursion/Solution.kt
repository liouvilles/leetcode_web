class Solution {
    fun isSameTree(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null || second == null) return first === second
        return first.`val` == second.`val` && isSameTree(first.left, second.left) && isSameTree(first.right, second.right)
    }
}
