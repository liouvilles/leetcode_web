class Solution {
    fun maximumTripletValue(nums:IntArray):Long{
        var maximum=nums[0];
        var difference=0;
        var answer=0L;
        for(k in 1 until nums.size){
            answer=maxOf(answer,difference.toLong()*nums[k]);
            difference=maxOf(difference,maximum-nums[k]);
            maximum=maxOf(maximum,nums[k])
        };
        return answer
    }
}
