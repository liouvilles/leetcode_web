class Solution {
    fun countPartitions(nums:IntArray,k:Int):Int{
        val mod=1_000_000_007L;
        var sum=0L;
        var total=1L;
        for(value in nums){
            sum+=value;
            total=total*2%mod
        };
        if(sum<2L*k)return 0;
        val dp=LongArray(k);
        dp[0]=1;
        for(value in nums)for(current in k-1 downTo value)dp[current]=(dp[current]+dp[current-value])%mod;
        var bad=0L;
        for(ways in dp)bad=(bad+ways)%mod;
        return ((total-2*bad%mod+mod)%mod).toInt()
    }
}
