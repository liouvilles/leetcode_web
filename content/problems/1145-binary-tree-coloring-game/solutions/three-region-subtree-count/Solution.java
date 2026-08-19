class Solution {
    private int leftSize,rightSize,target;
    public boolean btreeGameWinningMove(TreeNode root,int n,int x){
        target=x;
        size(root);
        int parent=n-1-leftSize-rightSize;
        return Math.max(parent,Math.max(leftSize,rightSize))>n/2;
    }
    private int size(TreeNode node){
        if(node==null)return 0;
        int left=size(node.left),right=size(node.right);
        if(node.val==target){
            leftSize=left;
            rightSize=right;
        }
        return left+right+1;
    }
}
