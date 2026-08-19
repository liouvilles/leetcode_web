class Solution {
    fun longestContinuousSubstring(s:String):Int{
        var current=1;
        var answer=1;
        for(i in 1 until s.length){
            current=if(s[i].code==s[i-1].code+1)current+1 else 1;
            answer=maxOf(answer,current)
        };
        return answer
    }
}
