class Solution {
    fun hasTrailingZeros(nums:IntArray):Boolean{
        var even=0;
        for(value in nums)if(value and 1==0&&++even==2)return true;
        return false
    }
}
