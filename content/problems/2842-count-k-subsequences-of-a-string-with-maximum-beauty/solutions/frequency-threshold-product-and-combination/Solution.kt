class Solution {
    private val mod=1000000007L;
    private fun power(base:Long,exponentInput:Int):Long{
        var exponent=exponentInput;
        var answer=1L;
        repeat(exponent){
            answer=answer*base%mod
        };
        return answer
    };
    private fun combination(n:Int,rInput:Int):Long{
        val r=minOf(rInput,n-rInput);
        var answer=1L;
        for(i in 1..r)answer=answer*(n-r+i)/i;
        return answer
    };
    fun countKSubsequencesWithMaxBeauty(s:String,k:Int):Int{
        val frequency=IntArray(26);
        for(ch in s)frequency[ch-'a']++;
        val values=frequency.filter{
            it>0
        }.sortedDescending();
        if(values.size<k)return 0;
        val threshold=values[k-1];
        var greater=0;
        var equal=0;
        var answer=1L;
        for(value in frequency)if(value>threshold){
            answer=answer*value%mod;
            greater++
        }else if(value==threshold)equal++;
        val needed=k-greater;
        answer=answer*power(threshold.toLong(),needed)%mod;
        answer=answer*(combination(equal,needed)%mod)%mod;
        return answer.toInt()
    }
}
