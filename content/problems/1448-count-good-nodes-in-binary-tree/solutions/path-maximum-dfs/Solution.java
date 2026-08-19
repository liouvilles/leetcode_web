class Solution {
    private int dfs(TreeNode node,int maximum){
        if(node==null)return 0;
        int good=node.val>=maximum?1:0,nextMaximum=Math.max(maximum,node.val);
        return good+dfs(node.left,nextMaximum)+dfs(node.right,nextMaximum);
    }
    public int goodNodes(TreeNode root){
        return dfs(root,Integer.MIN_VALUE);
    }
}
