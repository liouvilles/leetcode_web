class Solution {
    fun longestSubsequence(s:String,k:Int):Int{
        var value=0L;
        var power=1L;
        var length=0;
        for(i in s.length-1 downTo 0){
            if(s[i]=='0')length++ else if(value+power<=k){
                value+=power;
                length++
            };
            if(power<=k)power*=2
        };
        return length
    }
}
