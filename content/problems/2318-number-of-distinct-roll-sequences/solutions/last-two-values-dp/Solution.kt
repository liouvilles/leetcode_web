class Solution {
    private val mod=1_000_000_007L;
    private fun gcd(aValue:Int,bValue:Int):Int{
        var a=aValue;
        var b=bValue;
        while(b!=0){
            val t=a%b;
            a=b;
            b=t
        };
        return a
    };
    fun distinctSequences(n:Int):Int{
        if(n==1)return 6;
        var dp=Array(7){
            LongArray(7)
        };
        for(a in 1..6)for(b in 1..6)if(a!=b&&gcd(a,b)==1)dp[a][b]=1;
        for(length in 3..n){
            val next=Array(7){
                LongArray(7)
            };
            for(previous in 1..6)for(last in 1..6)if(dp[previous][last]>0)for(value in 1..6)if(value!=last&&value!=previous&&gcd(last,value)==1)next[last][value]=(next[last][value]+dp[previous][last])%mod;
            dp=next
        };
        var answer=0L;
        for(row in dp)for(value in row)answer=(answer+value)%mod;
        return answer.toInt()
    }
}
