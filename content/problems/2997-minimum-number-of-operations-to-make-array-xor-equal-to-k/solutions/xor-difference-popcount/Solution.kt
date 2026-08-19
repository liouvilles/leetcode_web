class Solution {
    fun minOperations(nums:IntArray,k:Int):Int{
        var xor=k;
        for(value in nums)xor=xor xor value;
        return Integer.bitCount(xor)
    }
}
