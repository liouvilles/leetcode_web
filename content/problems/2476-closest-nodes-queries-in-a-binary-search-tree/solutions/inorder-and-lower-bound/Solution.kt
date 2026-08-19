class Solution {
    private fun inorder(node:TreeNode?,sorted:MutableList<Int>){
        if(node==null)return;
        inorder(node.left,sorted);
        sorted.add(node.`val`);
        inorder(node.right,sorted)
    }
    private fun lowerBound(sorted:List<Int>,target:Int):Int{
        var left=0;
        var right=sorted.size;
        while(left<right){
            val middle=(left+right) ushr 1;
            if(sorted[middle]<target)left=middle+1 else right=middle
        };
        return left
    }
    fun closestNodes(root:TreeNode?,queries:List<Int>):List<List<Int>>{
        val sorted=mutableListOf<Int>();
        inorder(root,sorted);
        return queries.map{
            query->val index=lowerBound(sorted,query);
            val upper=if(index<sorted.size)sorted[index]else -1;
            val lower=if(index<sorted.size&&sorted[index]==query)query else if(index>0)sorted[index-1]else -1;
            listOf(lower,upper)
        }
    }
}
