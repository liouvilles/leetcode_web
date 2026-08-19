class Solution {
    public TreeNode getTargetCopy(TreeNode original,TreeNode cloned,TreeNode target){
        if(original==null)return null;
        if(original.val==target.val)return cloned;
        TreeNode left=getTargetCopy(original.left,cloned.left,target);
        return left!=null?left:getTargetCopy(original.right,cloned.right,target);
    }
}
