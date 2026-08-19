class Skiplist {
    private companion object{
        const val MAX_LEVEL=16
    };
    private class Node(val value:Int){
        val next=arrayOfNulls<Node>(MAX_LEVEL)
    };
    private val head=Node(-1);
    private var seed=1;
    private fun predecessors(target:Int):Array<Node>{
        val update=Array(MAX_LEVEL){
            head
        };
        var node=head;
        for(level in MAX_LEVEL-1 downTo 0){
            while(node.next[level]!=null&&node.next[level]!!.value<target)node=node.next[level]!!;
            update[level]=node
        };
        return update
    };
    private fun randomLevel():Int{
        var level=1;
        while(level<MAX_LEVEL){
            seed=seed*1103515245+12345;
            if(seed and 1!=0)break;
            level++
        };
        return level
    };
    fun search(target:Int):Boolean{
        val node=predecessors(target)[0].next[0];
        return node!=null&&node.value==target
    };
    fun add(num:Int){
        val update=predecessors(num);
        val node=Node(num);
        for(level in 0 until randomLevel()){
            node.next[level]=update[level].next[level];
            update[level].next[level]=node
        }
    };
    fun erase(num:Int):Boolean{
        val update=predecessors(num);
        val target=update[0].next[0];
        if(target==null||target.value!=num)return false;
        for(level in 0 until MAX_LEVEL){
            if(update[level].next[level]!==target)break;
            update[level].next[level]=target.next[level]
        };
        return true
    }
}
