class Solution {
    private int answer;
    public int maxPathSum(TreeNode root) { answer = Integer.MIN_VALUE; gain(root); return answer; }
    private int gain(TreeNode node) { if (node == null) return 0; int left = Math.max(0, gain(node.left)), right = Math.max(0, gain(node.right)); answer = Math.max(answer, node.val + left + right); return node.val + Math.max(left, right); }
}
