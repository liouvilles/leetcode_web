class Solution {
    fun xorGame(nums:IntArray):Boolean{
        var xor=0;
        for(value in nums)xor=xor xor value;
        return xor==0||nums.size%2==0
    }
}
