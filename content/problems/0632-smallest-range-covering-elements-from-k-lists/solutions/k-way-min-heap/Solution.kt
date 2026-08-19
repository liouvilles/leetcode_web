class Solution {
    fun smallestRange(nums:List<List<Int>>):IntArray{
        val heap=java.util.PriorityQueue<IntArray>(compareBy{
            it[0]
        });
        var maximum=Int.MIN_VALUE;
        for(row in nums.indices){
            val value=nums[row][0];
            heap.add(intArrayOf(value,row,0));
            maximum=maxOf(maximum,value)
        };
        var bestLeft=heap.peek()[0];
        var bestRight=maximum;
        while(true){
            val item=heap.remove();
            val minimum=item[0];
            if(maximum-minimum<bestRight-bestLeft||(maximum-minimum==bestRight-bestLeft&&minimum<bestLeft)){
                bestLeft=minimum;
                bestRight=maximum
            };
            val nextIndex=item[2]+1;
            if(nextIndex==nums[item[1]].size)break;
            val next=nums[item[1]][nextIndex];
            heap.add(intArrayOf(next,item[1],nextIndex));
            maximum=maxOf(maximum,next)
        };
        return intArrayOf(bestLeft,bestRight)
    }
}
