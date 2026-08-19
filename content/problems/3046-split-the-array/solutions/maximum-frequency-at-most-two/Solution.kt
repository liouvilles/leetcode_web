class Solution {
    fun isPossibleToSplit(nums:IntArray):Boolean{
        val frequency=IntArray(101);
        for(value in nums)if(++frequency[value]>2)return false;
        return true
    }
}
