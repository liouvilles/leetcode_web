class Solution {
    fun largestValues(root:TreeNode?):List<Int>{
        if(root==null)return emptyList();
        val answer=mutableListOf<Int>();
        val queue=ArrayDeque<TreeNode>();
        queue.addLast(root);
        while(queue.isNotEmpty()){
            var maximum=Int.MIN_VALUE;
            repeat(queue.size){
                val node=queue.removeFirst();
                maximum=maxOf(maximum,node.`val`);
                node.left?.let{
                    queue.addLast(it)
                };
                node.right?.let{
                    queue.addLast(it)
                }
            };
            answer.add(maximum)
        };
        return answer
    }
}
