class Solution {
    fun sumRootToLeaf(root:TreeNode?):Int=dfs(root,0);
    private fun dfs(node:TreeNode?,prefix:Int):Int{
        node?:return 0;
        val current=(prefix shl 1) or node.`val`;
        if(node.left==null&&node.right==null)return current;
        return dfs(node.left,current)+dfs(node.right,current)
    }
}
