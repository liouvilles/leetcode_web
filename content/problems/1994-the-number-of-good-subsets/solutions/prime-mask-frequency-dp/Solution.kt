class Solution {
    fun numberOfGoodSubsets(nums:IntArray):Int{
        val mod=1_000_000_007L;
        val frequency=IntArray(31);
        val primes=intArrayOf(2,3,5,7,11,13,17,19,23,29);
        for(value in nums)frequency[value]++;
        var dp=LongArray(1 shl 10);
        dp[0]=1;
        for(value in 2..30)if(frequency[value]>0){
            var mask=0;
            var valid=true;
            for(bit in primes.indices){
                if(value%(primes[bit]*primes[bit])==0)valid=false;
                if(value%primes[bit]==0)mask=mask or (1 shl bit)
            };
            if(!valid)continue;
            val next=dp.clone();
            for(state in dp.indices)if(state and mask==0)next[state or mask]=(next[state or mask]+dp[state]*frequency[value])%mod;
            dp=next
        };
        var answer=(1 until dp.size).sumOf{
            dp[it]
        }%mod;
        repeat(frequency[1]){
            answer=answer*2%mod
        };
        return answer.toInt()
    }
}
