class Solution {
    private int sum;
    public TreeNode convertBST(TreeNode root){
        traverse(root);
        return root;
    }
    private void traverse(TreeNode node){
        if(node==null)return;
        traverse(node.right);
        sum+=node.val;
        node.val=sum;
        traverse(node.left);
    }
}
