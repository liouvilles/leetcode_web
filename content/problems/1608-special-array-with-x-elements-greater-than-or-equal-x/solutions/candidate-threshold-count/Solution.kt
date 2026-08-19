class Solution {
    fun specialArray(nums:IntArray):Int{
        for(x in 0..nums.size)if(nums.count{
            it>=x
        }==x)return x;
        return -1
    }
}
