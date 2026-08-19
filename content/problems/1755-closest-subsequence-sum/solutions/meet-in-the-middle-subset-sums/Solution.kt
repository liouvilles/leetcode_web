class Solution {
    private fun sums(nums:IntArray,start:Int,length:Int):IntArray{
        val sums=IntArray(1 shl length);
        for(mask in 1 until sums.size){
            val bit=Integer.numberOfTrailingZeros(mask);
            sums[mask]=sums[mask xor (1 shl bit)]+nums[start+bit]
        };
        return sums
    };
    fun minAbsDifference(nums:IntArray,goal:Int):Int{
        val middle=nums.size/2;
        val left=sums(nums,0,middle);
        val right=sums(nums,middle,nums.size-middle);
        right.sort();
        var answer=kotlin.math.abs(goal);
        for(value in left){
            val target=goal-value;
            var index=right.binarySearch(target);
            if(index>=0)return 0;
            index=-index-1;
            if(index<right.size)answer=minOf(answer,kotlin.math.abs(value+right[index]-goal));
            if(index>0)answer=minOf(answer,kotlin.math.abs(value+right[index-1]-goal))
        };
        return answer
    }
}
