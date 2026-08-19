class Solution {
    fun minStartValue(nums:IntArray):Int{
        var prefix=0;
        var minimum=0;
        for(value in nums){
            prefix+=value;
            minimum=minOf(minimum,prefix)
        };
        return 1-minimum
    }
}
