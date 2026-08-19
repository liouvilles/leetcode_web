class Solution {
    private var distance=0;
    private var answer=0;
    private fun dfs(node:TreeNode?):IntArray{
        val count=IntArray(distance+1);
        if(node==null)return count;
        if(node.left==null&&node.right==null){
            count[0]=1;
            return count
        };
        val left=dfs(node.left);
        val right=dfs(node.right);
        for(i in 0..distance)for(j in 0..distance)if(i+j+2<=distance)answer+=left[i]*right[j];
        for(d in 0 until distance)count[d+1]=left[d]+right[d];
        return count
    };
    fun countPairs(root:TreeNode?,distance:Int):Int{
        this.distance=distance;
        dfs(root);
        return answer
    }
}
