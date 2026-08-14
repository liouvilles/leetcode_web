class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>(); if (root == null) return answer; Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root); boolean leftToRight = true;
        while (!queue.isEmpty()) { int size = queue.size(); Integer[] level = new Integer[size]; for (int index = 0; index < size; index++) { TreeNode node = queue.poll(); level[leftToRight ? index : size - 1 - index] = node.val; if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } answer.add(Arrays.asList(level)); leftToRight = !leftToRight; }
        return answer;
    }
}
