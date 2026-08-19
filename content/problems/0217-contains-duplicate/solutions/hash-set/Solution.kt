class Solution {
    fun containsDuplicate(nums:IntArray):Boolean{
        val seen=hashSetOf<Int>();
        for(value in nums)if(!seen.add(value))return true;
        return false
    }
}
