class Solution {
    fun minDeletionSize(strs:Array<String>):Int{
        val columns=strs[0].length;
        val dp=IntArray(columns){
            1
        };
        var longest=1;
        for(j in 0 until columns){
            for(i in 0 until j){
                var compatible=true;
                for(word in strs)if(word[i]>word[j]){
                    compatible=false;
                    break
                };
                if(compatible)dp[j]=maxOf(dp[j],dp[i]+1)
            };
            longest=maxOf(longest,dp[j])
        };
        return columns-longest
    }
}
