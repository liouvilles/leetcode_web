class Solution {
    fun minNumber(nums1:IntArray,nums2:IntArray):Int{
        val present=BooleanArray(10);
        for(value in nums1)present[value]=true;
        var common=10;
        for(value in nums2)if(present[value])common=minOf(common,value);
        if(common<10)return common;
        val first=nums1.minOrNull()!!;
        val second=nums2.minOrNull()!!;
        return minOf(first,second)*10+maxOf(first,second)
    }
}
