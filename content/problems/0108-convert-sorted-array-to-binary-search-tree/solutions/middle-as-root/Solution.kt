class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? { fun build(left: Int, right: Int): TreeNode? { if (left > right) return null; val middle = left + (right - left) / 2; val root = TreeNode(nums[middle]); root.left = build(left, middle - 1); root.right = build(middle + 1, right); return root }; return build(0, nums.lastIndex) }
}
