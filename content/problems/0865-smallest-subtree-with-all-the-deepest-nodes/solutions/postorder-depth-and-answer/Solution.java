class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root){
        return dfs(root).node;
    }
    private Result dfs(TreeNode node){
        if(node==null)return new Result(0,null);
        Result left=dfs(node.left),right=dfs(node.right);
        if(left.depth==right.depth)return new Result(left.depth+1,node);
        return left.depth>right.depth?new Result(left.depth+1,left.node):new Result(right.depth+1,right.node);
    }
    private static class Result{
        int depth;
        TreeNode node;
        Result(int depth,TreeNode node){
            this.depth=depth;
            this.node=node;
        }
    }
}
