class Solution {
    public int sumRootToLeaf(TreeNode root){
        return dfs(root,0);
    }
    private int dfs(TreeNode node,int prefix){
        if(node==null)return 0;
        int current=(prefix<<1)|node.val;
        if(node.left==null&&node.right==null)return current;
        return dfs(node.left,current)+dfs(node.right,current);
    }
}
