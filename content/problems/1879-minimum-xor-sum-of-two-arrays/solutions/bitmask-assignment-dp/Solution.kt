class Solution {
    private lateinit var first:IntArray;
    private lateinit var second:IntArray;
    private lateinit var memo:IntArray;
    private fun dfs(mask:Int):Int{
        if(mask==(1 shl first.size)-1)return 0;
        if(memo[mask]!=-1)return memo[mask];
        val index=Integer.bitCount(mask);
        var best=Int.MAX_VALUE;
        for(j in second.indices)if(mask and (1 shl j)==0)best=minOf(best,(first[index] xor second[j])+dfs(mask or (1 shl j)));
        memo[mask]=best;
        return best
    };
    fun minimumXORSum(nums1:IntArray,nums2:IntArray):Int{
        first=nums1;
        second=nums2;
        memo=IntArray(1 shl nums1.size){
            -1
        };
        return dfs(0)
    }
}
