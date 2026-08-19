class Solution {
    fun minimumDistance(word:String):Int{
        val infinity=1000000;
        var dp=IntArray(27){
            infinity
        };
        dp[26]=0;
        for(i in 1 until word.length){
            val current=word[i-1]-'A';
            val target=word[i]-'A';
            val next=IntArray(27){
                infinity
            };
            for(other in 0..26)if(dp[other]<infinity){
                next[other]=minOf(next[other],dp[other]+distance(current,target));
                next[current]=minOf(next[current],dp[other]+distance(other,target))
            };
            dp=next
        };
        return dp.min()
    };
    private fun distance(a:Int,b:Int):Int{
        if(a==26||b==26)return 0;
        return kotlin.math.abs(a/6-b/6)+kotlin.math.abs(a%6-b%6)
    }
}
