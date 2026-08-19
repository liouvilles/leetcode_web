class Solution {
    private fun swaps(values:List<Int>):Int{
        val order=values.indices.sortedBy{
            values[it]
        };
        val visited=BooleanArray(values.size);
        var answer=0;
        for(i in values.indices)if(!visited[i]){
            var node=i;
            var length=0;
            while(!visited[node]){
                visited[node]=true;
                node=order[node];
                length++
            };
            answer+=length-1
        };
        return answer
    }
    fun minimumOperations(root:TreeNode?):Int{
        val queue=java.util.ArrayDeque<TreeNode>();
        queue.offer(root!!);
        var answer=0;
        while(queue.isNotEmpty()){
            var size=queue.size;
            val values=mutableListOf<Int>();
            while(size-->0){
                val node=queue.poll();
                values.add(node.`val`);
                node.left?.let{
                    queue.offer(it)
                };
                node.right?.let{
                    queue.offer(it)
                }
            };
            answer+=swaps(values)
        };
        return answer
    }
}
