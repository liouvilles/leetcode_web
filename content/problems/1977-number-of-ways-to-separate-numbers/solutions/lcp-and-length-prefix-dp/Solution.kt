class Solution {
    companion object{
        const val MOD=1_000_000_007
    };
    private lateinit var value:String;
    private lateinit var lcp:Array<ShortArray>;
    private fun lessOrEqual(first:Int,second:Int,length:Int):Boolean{
        val common=lcp[first][second].toInt();
        return common>=length||value[first+common]<=value[second+common]
    };
    fun numberOfCombinations(num:String):Int{
        if(num[0]=='0')return 0;
        value=num;
        val n=num.length;
        lcp=Array(n+1){
            ShortArray(n+1)
        };
        for(first in n-1 downTo 0)for(second in n-1 downTo 0)if(num[first]==num[second])lcp[first][second]=(lcp[first+1][second+1]+1).toShort();
        val prefix=Array(n+1){
            IntArray(n+1)
        };
        for(end in 1..n)for(length in 1..end){
            val start=end-length;
            var ways=0L;
            if(num[start]!='0'){
                if(start==0)ways=1 else{
                    ways=prefix[start][minOf(length-1,start)].toLong();
                    if(length<=start&&lessOrEqual(start-length,start,length)){
                        var equal=prefix[start][length]-prefix[start][length-1];
                        if(equal<0)equal+=MOD;
                        ways+=equal
                    }
                }
            };
            prefix[end][length]=((prefix[end][length-1]+ways)%MOD).toInt()
        };
        return prefix[n][n]
    }
}
