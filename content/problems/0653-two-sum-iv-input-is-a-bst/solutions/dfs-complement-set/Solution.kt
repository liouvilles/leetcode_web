class Solution {
    fun findTarget(root:TreeNode?,k:Int):Boolean{
        val seen=hashSetOf<Int>();
        fun dfs(node:TreeNode?):Boolean{
            if(node==null)return false;
            if(k-node.`val` in seen)return true;
            seen.add(node.`val`);
            return dfs(node.left)||dfs(node.right)
        };
        return dfs(root)
    }
}
