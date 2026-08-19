class Solution {
    fun fairCandySwap(aliceSizes:IntArray,bobSizes:IntArray):IntArray{
        val difference=(aliceSizes.sum()-bobSizes.sum())/2;
        val bob=bobSizes.toSet();
        for(alice in aliceSizes)if(alice-difference in bob)return intArrayOf(alice,alice-difference);
        return intArrayOf()
    }
}
