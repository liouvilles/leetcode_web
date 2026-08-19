class Solution {
    fun verticalTraversal(root:TreeNode?):List<List<Int>>{
        val nodes=mutableListOf<IntArray>();
        fun collect(node:TreeNode?,row:Int,column:Int){
            node?:return;
            nodes.add(intArrayOf(column,row,node.`val`));
            collect(node.left,row+1,column-1);
            collect(node.right,row+1,column+1)
        };
        collect(root,0,0);
        nodes.sortWith(compareBy<IntArray>{
            it[0]
        }.thenBy{
            it[1]
        }.thenBy{
            it[2]
        });
        val answer=mutableListOf<MutableList<Int>>();
        var column=Int.MIN_VALUE;
        for(node in nodes){
            if(node[0]!=column){
                column=node[0];
                answer.add(mutableListOf())
            };
            answer.last().add(node[2])
        };
        return answer
    }
}
