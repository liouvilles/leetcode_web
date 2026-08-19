class Solution {
    fun countPalindromicSubsequence(s:String):Int{
        val first=IntArray(26){
            -1
        };
        val last=IntArray(26);
        for(i in s.indices){
            val value=s[i]-'a';
            if(first[value]==-1)first[value]=i;
            last[value]=i
        };
        var answer=0;
        for(value in 0 until 26)if(first[value]+1<last[value]){
            val middle=BooleanArray(26);
            for(i in first[value]+1 until last[value])middle[s[i]-'a']=true;
            answer+=middle.count{
                it
            }
        };
        return answer
    }
}
