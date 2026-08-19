class Solution {
    public int maxAncestorDiff(TreeNode root){
        return dfs(root,root.val,root.val);
    }
    private int dfs(TreeNode node,int minimum,int maximum){
        if(node==null)return maximum-minimum;
        minimum=Math.min(minimum,node.val);
        maximum=Math.max(maximum,node.val);
        return Math.max(dfs(node.left,minimum,maximum),dfs(node.right,minimum,maximum));
    }
}
