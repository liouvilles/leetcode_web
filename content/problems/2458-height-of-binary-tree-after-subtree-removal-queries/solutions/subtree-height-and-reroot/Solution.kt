class Solution {
    private val height=HashMap<Int,Int>();
    private val answer=HashMap<Int,Int>();
    private fun measure(node:TreeNode?):Int{
        if(node==null)return 0;
        val value=1+maxOf(measure(node.left),measure(node.right));
        height[node.`val`]=value;
        return value
    }
    private fun reroot(node:TreeNode?,depth:Int,rest:Int){
        if(node==null)return;
        answer[node.`val`]=rest;
        reroot(node.left,depth+1,maxOf(rest,depth+(node.right?.let{
            height[it.`val`]
        }?:0)));
        reroot(node.right,depth+1,maxOf(rest,depth+(node.left?.let{
            height[it.`val`]
        }?:0)))
    }
    fun treeQueries(root:TreeNode?,queries:IntArray):IntArray{
        measure(root);
        reroot(root,0,0);
        return IntArray(queries.size){
            answer[queries[it]]!!
        }
    }
}
