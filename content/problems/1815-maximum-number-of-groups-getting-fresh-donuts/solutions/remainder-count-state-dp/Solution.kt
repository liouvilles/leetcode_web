class Solution {
    private var batchSize=0;
    private val memo=mutableMapOf<Long,Int>();
    private fun dfs(state:Long,current:Int):Int{
        if(state==0L)return 0;
        val key=state*batchSize+current;
        memo[key]?.let{
            return it
        };
        var best=0;
        for(remainder in 1 until batchSize){
            val shift=(remainder-1)*5;
            if(state shr shift and 31L==0L)continue;
            best=maxOf(best,(if(current==0)1 else 0)+dfs(state-(1L shl shift),(current+remainder)%batchSize))
        };
        memo[key]=best;
        return best
    };
    fun maxHappyGroups(batchSize:Int,groups:IntArray):Int{
        this.batchSize=batchSize;
        memo.clear();
        val count=IntArray(batchSize);
        for(group in groups)count[group%batchSize]++;
        var state=0L;
        for(remainder in 1 until batchSize)state=state or (count[remainder].toLong() shl ((remainder-1)*5));
        return count[0]+dfs(state,0)
    }
}
