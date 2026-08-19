class Solution {
    private val bound=1000000;
    private lateinit var blocked:Set<Long>;
    private var limit=0;
    fun isEscapePossible(blockedCells:Array<IntArray>,source:IntArray,target:IntArray):Boolean{
        fun key(r:Int,c:Int):Long{
            return r.toLong()*bound+c
        };
        blocked=blockedCells.map{
            key(it[0],it[1])
        }.toSet();
        limit=blockedCells.size*(blockedCells.size-1)/2;
        return search(source,target)&&search(target,source)
    };
    private fun search(start:IntArray,finish:IntArray):Boolean{
        fun key(r:Int,c:Int):Long{
            return r.toLong()*bound+c
        };
        val queue=java.util.ArrayDeque<IntArray>();
        val seen=mutableSetOf(key(start[0],start[1]));
        queue.addLast(start);
        val directions=arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1));
        while(queue.isNotEmpty()&&seen.size<=limit){
            val cell=queue.removeFirst();
            for(d in directions){
                val r=cell[0]+d[0];
                val c=cell[1]+d[1];
                if(r !in 0 until bound||c !in 0 until bound)continue;
                if(r==finish[0]&&c==finish[1])return true;
                val code=key(r,c);
                if(code !in blocked&&seen.add(code))queue.addLast(intArrayOf(r,c))
            }
        };
        return seen.size>limit
    }
}
