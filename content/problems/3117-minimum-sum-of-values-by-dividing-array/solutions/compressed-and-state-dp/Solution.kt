class Solution {
    private fun putMin(map:HashMap<Int,Int>,key:Int,value:Int){
        val previous=map[key];
        if(previous==null||value<previous)map[key]=value
    }
    fun minimumValueSum(nums:IntArray,andValues:IntArray):Int{
        val parts=andValues.size;
        var active=Array(parts){
            HashMap<Int,Int>()
        };
        active[0][-1]=0;
        var answer=Int.MAX_VALUE;
        for(index in nums.indices){
            val next=Array(parts){
                HashMap<Int,Int>()
            };
            for(part in 0 until parts)for((currentAnd,cost) in active[part]){
                val merged=currentAnd and nums[index];
                val target=andValues[part];
                if(merged and target!=target)continue;
                putMin(next[part],merged,cost);
                if(merged==target){
                    val closed=cost+nums[index];
                    if(part==parts-1){
                        if(index==nums.lastIndex)answer=minOf(answer,closed)
                    }else putMin(next[part+1],-1,closed)
                }
            };
            active=next
        };
        return if(answer==Int.MAX_VALUE)-1 else answer
    }
}
