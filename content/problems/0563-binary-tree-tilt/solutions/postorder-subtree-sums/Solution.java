class Solution {
    private int tilt;
    public int findTilt(TreeNode root){
        tilt=0;
        sum(root);
        return tilt;
    }
    private int sum(TreeNode node){
        if(node==null)return 0;
        int left=sum(node.left),right=sum(node.right);
        tilt+=Math.abs(left-right);
        return left+right+node.val;
    }
}
