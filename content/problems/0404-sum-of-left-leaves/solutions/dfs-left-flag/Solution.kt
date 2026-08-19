class Solution {
    fun sumOfLeftLeaves(root:TreeNode?):Int{
        fun dfs(node:TreeNode?,left:Boolean):Int{
            if(node==null)return 0;
            if(node.left==null&&node.right==null)return if(left)node.`val` else 0;
            return dfs(node.left,true)+dfs(node.right,false)
        };
        return dfs(root,false)
    }
}
