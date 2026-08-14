class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root);
        while (!queue.isEmpty()) { int size = queue.size(); for (int index = 0; index < size; index++) { TreeNode node = queue.poll(); if (index == size - 1) answer.add(node.val); if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } }
        return answer;
    }
}
