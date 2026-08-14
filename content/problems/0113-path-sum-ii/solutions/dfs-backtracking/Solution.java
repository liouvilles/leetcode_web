class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) { List<List<Integer>> answer = new ArrayList<>(); dfs(root, targetSum, new ArrayList<>(), answer); return answer; }
    private void dfs(TreeNode node, long remaining, List<Integer> path, List<List<Integer>> answer) { if (node == null) return; path.add(node.val); if (node.left == null && node.right == null && remaining == node.val) answer.add(new ArrayList<>(path)); else { dfs(node.left, remaining - node.val, path, answer); dfs(node.right, remaining - node.val, path, answer); } path.remove(path.size() - 1); }
}
