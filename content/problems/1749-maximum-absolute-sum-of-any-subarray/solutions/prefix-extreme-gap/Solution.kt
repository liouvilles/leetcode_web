class Solution {
    fun maxAbsoluteSum(nums:IntArray):Int{
        var prefix=0;
        var minimum=0;
        var maximum=0;
        for(value in nums){
            prefix+=value;
            minimum=minOf(minimum,prefix);
            maximum=maxOf(maximum,prefix)
        };
        return maximum-minimum
    }
}
