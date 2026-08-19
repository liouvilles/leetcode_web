class Solution {
    fun maxAlternatingSum(nums:IntArray):Long{
        var plus=0L;
        var minus=0L;
        for(value in nums){
            val oldPlus=plus;
            val oldMinus=minus;
            plus=maxOf(oldPlus,oldMinus+value);
            minus=maxOf(oldMinus,oldPlus-value)
        };
        return plus
    }
}
