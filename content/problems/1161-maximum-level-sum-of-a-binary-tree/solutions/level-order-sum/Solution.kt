class Solution {
    fun maxLevelSum(root:TreeNode?):Int{
        val queue=java.util.ArrayDeque<TreeNode>();
        queue.addLast(root!!);
        var level=0;
        var bestLevel=0;
        var bestSum=Int.MIN_VALUE;
        while(queue.isNotEmpty()){
            level++;
            var size=queue.size;
            var sum=0;
            while(size-->0){
                val node=queue.removeFirst();
                sum+=node.`val`;
                node.left?.let{
                    queue.addLast(it)
                };
                node.right?.let{
                    queue.addLast(it)
                }
            };
            if(sum>bestSum){
                bestSum=sum;
                bestLevel=level
            }
        };
        return bestLevel
    }
}
