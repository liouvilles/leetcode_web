class Solution {
    public List<Integer> preorderTraversal(TreeNode root) { List<Integer> answer = new ArrayList<>(); if (root == null) return answer; Deque<TreeNode> stack = new ArrayDeque<>(); stack.push(root); while (!stack.isEmpty()) { TreeNode node = stack.pop(); answer.add(node.val); if (node.right != null) stack.push(node.right); if (node.left != null) stack.push(node.left); } return answer; }
}
