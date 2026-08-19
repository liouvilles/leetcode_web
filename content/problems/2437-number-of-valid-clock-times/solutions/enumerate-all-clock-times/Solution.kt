class Solution {
    fun countTime(time:String):Int{
        var answer=0;
        for(hour in 0 until 24)for(minute in 0 until 60){
            val value="%02d:%02d".format(hour,minute);
            if(time.indices.all{
                time[it]=='?'||time[it]==value[it]
            })answer++
        };
        return answer
    }
}
