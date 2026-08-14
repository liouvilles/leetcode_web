class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> counts = new HashMap<>(); counts.put(0L, 1); return visit(root, 0L, targetSum, counts);
    }
    private int visit(TreeNode node, long prefix, long target, Map<Long, Integer> counts) {
        if (node == null) return 0;
        long current = prefix + node.val; int answer = counts.getOrDefault(current - target, 0); counts.put(current, counts.getOrDefault(current, 0) + 1);
        answer += visit(node.left, current, target, counts) + visit(node.right, current, target, counts);
        counts.put(current, counts.get(current) - 1); return answer;
    }
}
