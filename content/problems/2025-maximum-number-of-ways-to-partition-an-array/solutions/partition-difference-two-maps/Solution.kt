class Solution {
    private fun get(map:Map<Long,Int>,key:Long)=map[key]?:0;
    fun waysToPartition(nums:IntArray,k:Int):Int{
        val total=nums.sumOf{
            it.toLong()
        };
        val difference=LongArray(nums.size);
        val left=HashMap<Long,Int>();
        val right=HashMap<Long,Int>();
        var prefix=0L;
        for(pivot in 1 until nums.size){
            prefix+=nums[pivot-1];
            difference[pivot]=2*prefix-total;
            right[difference[pivot]]=(right[difference[pivot]]?:0)+1
        };
        var answer=get(right,0);
        for(index in nums.indices){
            if(index>0){
                val value=difference[index];
                right[value]=right[value]!!-1;
                left[value]=(left[value]?:0)+1
            };
            val delta=k.toLong()-nums[index];
            answer=maxOf(answer,get(left,delta)+get(right,-delta))
        };
        return answer
    }
}
