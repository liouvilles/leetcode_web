class Solution {
    fun minimumIncompatibility(nums:IntArray,k:Int):Int{
        val n=nums.size;
        val group=n/k;
        val total=1 shl n;
        val inf=1_000_000;
        val cost=IntArray(total){
            -1
        };
        for(mask in 0 until total)if(Integer.bitCount(mask)==group){
            var seen=0;
            var minimum=Int.MAX_VALUE;
            var maximum=0;
            var valid=true;
            for(i in 0 until n)if(mask and (1 shl i)!=0){
                val bit=1 shl (nums[i]-1);
                if(seen and bit!=0){
                    valid=false;
                    break
                };
                seen=seen or bit;
                minimum=minOf(minimum,nums[i]);
                maximum=maxOf(maximum,nums[i])
            };
            if(valid)cost[mask]=maximum-minimum
        };
        val dp=IntArray(total){
            inf
        };
        dp[0]=0;
        for(mask in 0 until total)if(dp[mask]<inf){
            val remaining=(total-1) xor mask;
            if(remaining==0)continue;
            val first=remaining and -remaining;
            var subset=remaining;
            while(subset>0){
                if(subset and first!=0&&cost[subset]>=0)dp[mask or subset]=minOf(dp[mask or subset],dp[mask]+cost[subset]);
                subset=(subset-1) and remaining
            }
        };
        return if(dp[total-1]>=inf)-1 else dp[total-1]
    }
}
