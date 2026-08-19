class Solution {
    fun minimumSteps(s:String):Long{
        var ones=0L;
        var answer=0L;
        for(ball in s)if(ball=='1')ones++ else answer+=ones;
        return answer
    }
}
