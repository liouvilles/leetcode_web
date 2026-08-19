class Solution {
    public boolean isUnivalTree(TreeNode root){
        return check(root,root.val);
    }
    private boolean check(TreeNode node,int target){
        return node==null||node.val==target&&check(node.left,target)&&check(node.right,target);
    }
}
