class Solution {
    fun peopleAwareOfSecret(n:Int,delay:Int,forget:Int):Int{
        val mod=1_000_000_007L;
        val learn=LongArray(n+1);
        learn[1]=1;
        var sharing=0L;
        for(day in 2..n){
            if(day-delay>=1)sharing=(sharing+learn[day-delay])%mod;
            if(day-forget>=1)sharing=(sharing-learn[day-forget]+mod)%mod;
            learn[day]=sharing
        };
        var answer=0L;
        for(day in maxOf(1,n-forget+1)..n)answer=(answer+learn[day])%mod;
        return answer.toInt()
    }
}
