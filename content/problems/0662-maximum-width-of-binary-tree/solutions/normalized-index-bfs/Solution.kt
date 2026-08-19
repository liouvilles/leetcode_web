class Solution {
    private data class State(val node:TreeNode,val index:Long);
    fun widthOfBinaryTree(root:TreeNode?):Int{
        val queue=java.util.ArrayDeque<State>();
        queue.add(State(root!!,0));
        var best=0L;
        while(queue.isNotEmpty()){
            val size=queue.size;
            val base=queue.peek().index;
            var first=0L;
            var last=0L;
            repeat(size){
                val state=queue.remove();
                val index=state.index-base;
                if(it==0)first=index;
                if(it==size-1)last=index;
                state.node.left?.let{
                    node->queue.add(State(node,index*2))
                };
                state.node.right?.let{
                    node->queue.add(State(node,index*2+1))
                }
            };
            best=maxOf(best,last-first+1)
        };
        return best.toInt()
    }
}
