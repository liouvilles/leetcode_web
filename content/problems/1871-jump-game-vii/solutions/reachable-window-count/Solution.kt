class Solution {
    fun canReach(s:String,minJump:Int,maxJump:Int):Boolean{
        val dp=BooleanArray(s.length);
        dp[0]=true;
        var reachable=0;
        for(i in 1 until s.length){
            if(i-minJump>=0&&dp[i-minJump])reachable++;
            if(i-maxJump-1>=0&&dp[i-maxJump-1])reachable--;
            dp[i]=s[i]=='0'&&reachable>0
        };
        return dp.last()
    }
}
