class Solution {
    private fun range(start:Long,count:Long)=count*(2*start+count-1)/2;
    fun minimalKSum(nums:IntArray,k:Int):Long{
        nums.sort();
        var current=1L;
        var answer=0L;
        var remaining=k.toLong();
        for(value in nums){
            if(value<current)continue;
            val take=minOf(remaining,value-current);
            answer+=range(current,take);
            remaining-=take;
            if(remaining==0L)return answer;
            current=value.toLong()+1
        };
        return answer+range(current,remaining)
    }
}
