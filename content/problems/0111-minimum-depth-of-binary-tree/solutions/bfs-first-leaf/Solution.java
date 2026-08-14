class Solution {
    public int minDepth(TreeNode root) { if (root == null) return 0; Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root); int depth = 0; while (!queue.isEmpty()) { depth++; for (int size = queue.size(); size > 0; size--) { TreeNode node = queue.poll(); if (node.left == null && node.right == null) return depth; if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } } return depth; }
}
