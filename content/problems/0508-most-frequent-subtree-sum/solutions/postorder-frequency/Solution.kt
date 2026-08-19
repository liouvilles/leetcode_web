class Solution {
    fun findFrequentTreeSum(root:TreeNode?):IntArray{
        val counts=hashMapOf<Int,Int>();
        var best=0;
        fun dfs(node:TreeNode?):Int{
            if(node==null)return 0;
            val sum=node.`val`+dfs(node.left)+dfs(node.right);
            val count=(counts[sum]?:0)+1;
            counts[sum]=count;
            best=maxOf(best,count);
            return sum
        };
        dfs(root);
        return counts.filterValues{
            it==best
        }.keys.sorted().toIntArray()
    }
}
