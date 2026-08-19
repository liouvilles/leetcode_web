class Solution {
    fun findSecondMinimumValue(root:TreeNode?):Int{
        fun dfs(node:TreeNode?,minimum:Int):Long{
            if(node==null)return Long.MAX_VALUE;
            if(node.`val`>minimum)return node.`val`.toLong();
            return minOf(dfs(node.left,minimum),dfs(node.right,minimum))
        };
        val answer=dfs(root,root!!.`val`);
        return if(answer==Long.MAX_VALUE)-1 else answer.toInt()
    }
}
