class Solution {
    private int postIndex; private Map<Integer, Integer> positions;
    public TreeNode buildTree(int[] inorder, int[] postorder) { positions = new HashMap<>(); for (int index = 0; index < inorder.length; index++) positions.put(inorder[index], index); postIndex = postorder.length - 1; return build(0, inorder.length - 1, postorder); }
    private TreeNode build(int left, int right, int[] postorder) { if (left > right) return null; int value = postorder[postIndex--], middle = positions.get(value); TreeNode root = new TreeNode(value); root.right = build(middle + 1, right, postorder); root.left = build(left, middle - 1, postorder); return root; }
}
