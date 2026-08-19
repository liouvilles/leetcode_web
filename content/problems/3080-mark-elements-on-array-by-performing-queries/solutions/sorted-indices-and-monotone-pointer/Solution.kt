class Solution {
    fun unmarkedSumArray(nums:IntArray,queries:Array<IntArray>):LongArray{
        var remaining=0L;
        val order=Array(nums.size){
            it
        };
        for(value in nums)remaining+=value;
        order.sortWith(compareBy<Int>{
            nums[it]
        }.thenBy{
            it
        });
        val marked=BooleanArray(nums.size);
        val answer=LongArray(queries.size);
        var pointer=0;
        for(query in queries.indices){
            val index=queries[query][0];
            if(!marked[index]){
                marked[index]=true;
                remaining-=nums[index]
            };
            var need=queries[query][1];
            while(need>0){
                while(pointer<nums.size&&marked[order[pointer]])pointer++;
                if(pointer==nums.size)break;
                val chosen=order[pointer++];
                marked[chosen]=true;
                remaining-=nums[chosen];
                need--
            };
            answer[query]=remaining
        };
        return answer
    }
}
