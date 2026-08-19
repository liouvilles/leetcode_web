class Solution {
    fun findFinalValue(nums:IntArray,originalValue:Int):Int{
        val values=nums.toHashSet();
        var original=originalValue;
        while(original in values)original*=2;
        return original
    }
}
