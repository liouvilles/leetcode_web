class Solution {
    fun minimumTime(s:String):Int{
        val n=s.length;
        var leftCost=0;
        var answer=n;
        for(i in s.indices){
            if(s[i]=='1')leftCost=minOf(leftCost+2,i+1);
            answer=minOf(answer,leftCost+n-1-i)
        };
        return answer
    }
}
