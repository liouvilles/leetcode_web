class Solution {
    private var answer=0;
    private fun dfs(node:TreeNode?):IntArray{
        if(node==null)return intArrayOf(1,Int.MAX_VALUE,Int.MIN_VALUE,0);
        val left=dfs(node.left);
        val right=dfs(node.right);
        if(left[0]==1&&right[0]==1&&node.`val`>left[2]&&node.`val`<right[1]){
            val sum=left[3]+right[3]+node.`val`;
            answer=maxOf(answer,sum);
            return intArrayOf(1,minOf(node.`val`,left[1]),maxOf(node.`val`,right[2]),sum)
        };
        return intArrayOf(0,0,0,0)
    };
    fun maxSumBST(root:TreeNode?):Int{
        dfs(root);
        return answer
    }
}
