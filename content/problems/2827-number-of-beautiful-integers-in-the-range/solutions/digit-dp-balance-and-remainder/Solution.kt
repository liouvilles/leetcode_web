class Solution {
    private var digits="";
    private var divisor=1;
    private lateinit var memo:HashMap<Long,Int>;
    private fun key(pos:Int,balance:Int,remainder:Int,started:Boolean):Long{
        var state=pos.toLong();
        state=state*(2*digits.length+1)+balance+digits.length;
        state=state*divisor+remainder;
        return state*2+if(started)1 else 0
    };
    private fun dfs(pos:Int,balance:Int,remainder:Int,started:Boolean,tight:Boolean):Int{
        if(pos==digits.length)return if(started&&balance==0&&remainder==0)1 else 0;
        val state=key(pos,balance,remainder,started);
        if(!tight&&state in memo)return memo[state]!!;
        val limit=if(tight)digits[pos]-'0' else 9;
        var ways=0;
        for(digit in 0..limit){
            val nextStarted=started||digit!=0;
            var nextBalance=balance;
            var nextRemainder=remainder;
            if(nextStarted){
                nextBalance+=if(digit%2==0)1 else -1;
                nextRemainder=(remainder*10+digit)%divisor
            };
            ways+=dfs(pos+1,nextBalance,nextRemainder,nextStarted,tight&&digit==limit)
        };
        if(!tight)memo[state]=ways;
        return ways
    };
    private fun countUpTo(bound:Int):Int{
        if(bound<=0)return 0;
        digits=bound.toString();
        memo=HashMap();
        return dfs(0,0,0,false,true)
    };
    fun numberOfBeautifulIntegers(low:Int,high:Int,k:Int):Int{
        divisor=k;
        return countUpTo(high)-countUpTo(low-1)
    }
}
