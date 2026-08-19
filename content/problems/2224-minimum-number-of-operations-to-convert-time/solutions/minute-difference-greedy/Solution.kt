class Solution {
    private fun minutes(time:String)=time.substring(0,2).toInt()*60+time.substring(3).toInt();
    fun convertTime(current:String,correct:String):Int{
        var difference=minutes(correct)-minutes(current);
        var answer=0;
        for(step in intArrayOf(60,15,5,1)){
            answer+=difference/step;
            difference%=step
        };
        return answer
    }
}
