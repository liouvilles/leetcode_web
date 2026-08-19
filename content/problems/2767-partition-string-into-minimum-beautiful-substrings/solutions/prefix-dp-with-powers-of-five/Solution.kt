class Solution {
    fun minimumBeautifulSubstrings(s:String):Int{
        val powers=HashSet<Long>();
        val limit=1L shl s.length;
        var power=1L;
        while(power<limit){
            powers.add(power);
            power*=5
        };
        val inf=1000000;
        val dp=IntArray(s.length+1){
            inf
        };
        dp[0]=0;
        for(start in s.indices)if(dp[start]<inf&&s[start]!='0'){
            var value=0L;
            for(end in start until s.length){
                value=value*2+(s[end]-'0');
                if(value in powers)dp[end+1]=minOf(dp[end+1],dp[start]+1)
            }
        };
        return if(dp[s.length]==inf)-1 else dp[s.length]
    }
}
