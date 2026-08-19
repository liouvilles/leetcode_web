class Solution {
    fun minOperations(nums:IntArray,k:Int):Int{
        var operations=0;
        for(value in nums)if(value<k)operations++;
        return operations
    }
}
