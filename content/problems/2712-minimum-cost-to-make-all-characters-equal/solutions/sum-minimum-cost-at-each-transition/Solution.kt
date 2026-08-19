class Solution {
    fun minimumCost(s:String):Long{
        var answer=0L;
        for(i in 1 until s.length)if(s[i]!=s[i-1])answer+=minOf(i,s.length-i);
        return answer
    }
}
