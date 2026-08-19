class Solution {
    fun numPrimeArrangements(n:Int):Int{
        val prime=BooleanArray(n+1){
            true
        };
        prime[0]=false;
        if(n>=1)prime[1]=false;
        var value=2;
        while(value*value<=n){
            if(prime[value])for(multiple in value*value..n step value)prime[multiple]=false;
            value++
        };
        val count=prime.count{
            it
        };
        val mod=1000000007L;
        var answer=1L;
        for(number in 2..count)answer=answer*number%mod;
        for(number in 2..n-count)answer=answer*number%mod;
        return answer.toInt()
    }
}
