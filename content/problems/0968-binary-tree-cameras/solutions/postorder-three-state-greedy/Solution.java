class Solution {
    private int cameras=0;
    public int minCameraCover(TreeNode root){
        if(state(root)==0)cameras++;
        return cameras;
    }
    private int state(TreeNode node){
        if(node==null)return 2;
        int left=state(node.left),right=state(node.right);
        if(left==0||right==0){
            cameras++;
            return 1;
        }
        if(left==1||right==1)return 2;
        return 0;
    }
}
