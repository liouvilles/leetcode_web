class Solution {
    fun minFlipsMonoIncr(s:String):Int{
        var ones=0;
        var flips=0;
        for(ch in s)if(ch=='1')ones++ else flips=minOf(flips+1,ones);
        return flips
    }
}
