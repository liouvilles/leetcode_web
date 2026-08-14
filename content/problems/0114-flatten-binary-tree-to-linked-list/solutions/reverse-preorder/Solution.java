class Solution {
    private TreeNode previous;
    public void flatten(TreeNode root) { if (root == null) return; flatten(root.right); flatten(root.left); root.right = previous; root.left = null; previous = root; }
}
