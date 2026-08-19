class Solution {
    fun validArrangement(pairs:Array<IntArray>):Array<IntArray>{
        val graph=HashMap<Int,java.util.ArrayDeque<Int>>();
        val balance=HashMap<Int,Int>();
        for(pair in pairs){
            graph.getOrPut(pair[0]){
                java.util.ArrayDeque()
            }.addLast(pair[1]);
            balance[pair[0]]=(balance[pair[0]]?:0)+1;
            balance[pair[1]]=(balance[pair[1]]?:0)-1
        };
        var start=pairs[0][0];
        for((node,value) in balance)if(value==1)start=node;
        val stack=java.util.ArrayDeque<Int>();
        val reversed=mutableListOf<IntArray>();
        stack.addLast(start);
        while(stack.isNotEmpty()){
            val node=stack.peekLast();
            val edges=graph[node];
            if(edges!=null&&edges.isNotEmpty())stack.addLast(edges.removeLast())else{
                val end=stack.removeLast();
                if(stack.isNotEmpty())reversed.add(intArrayOf(stack.peekLast(),end))
            }
        };
        reversed.reverse();
        return reversed.toTypedArray()
    }
}
