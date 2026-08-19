class Solution {
    fun appealSum(s:String):Long{
        val last=IntArray(26){
            -1
        };
        var current=0L;
        var answer=0L;
        for(i in s.indices){
            val ch=s[i]-'a';
            current+=i-last[ch];
            last[ch]=i;
            answer+=current
        };
        return answer
    }
}
