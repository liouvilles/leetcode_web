class Solution {
    fun countDigitOne(n:Int):Int{
        var answer=0L;
        var factor=1L;
        while(factor<=n){
            val high=n/(factor*10);
            val current=n/factor%10;
            val low=n%factor;
            answer+=high*factor;
            if(current==1L)answer+=low+1 else if(current>1L)answer+=factor;
            factor*=10
        };
        return answer.toInt()
    }
}
