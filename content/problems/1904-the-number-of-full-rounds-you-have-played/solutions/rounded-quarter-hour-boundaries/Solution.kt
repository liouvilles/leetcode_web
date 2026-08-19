class Solution {
    private fun minutes(time:String)=time.substring(0,2).toInt()*60+time.substring(3).toInt();
    fun numberOfRounds(loginTime:String,logoutTime:String):Int{
        var start=minutes(loginTime);
        var finish=minutes(logoutTime);
        if(finish<start)finish+=1440;
        start=(start+14)/15*15;
        finish=finish/15*15;
        return maxOf(0,(finish-start)/15)
    }
}
