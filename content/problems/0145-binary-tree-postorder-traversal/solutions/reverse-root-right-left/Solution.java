class Solution {
    public List<Integer> postorderTraversal(TreeNode root) { LinkedList<Integer> answer = new LinkedList<>(); if (root == null) return answer; Deque<TreeNode> stack = new ArrayDeque<>(); stack.push(root); while (!stack.isEmpty()) { TreeNode node = stack.pop(); answer.addFirst(node.val); if (node.left != null) stack.push(node.left); if (node.right != null) stack.push(node.right); } return answer; }
}
