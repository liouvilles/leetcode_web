class TweetCounts {
    private val records=mutableMapOf<String,java.util.TreeMap<Int,Int>>();
    fun recordTweet(tweetName:String,time:Int){
        val times=records.getOrPut(tweetName){
            java.util.TreeMap()
        };
        times[time]=(times[time]?:0)+1
    };
    fun getTweetCountsPerFrequency(freq:String,tweetName:String,startTime:Int,endTime:Int):List<Int>{
        val width=if(freq=="minute")60 else if(freq=="hour")3600 else 86400;
        val answer=MutableList((endTime-startTime)/width+1){
            0
        };
        val times=records[tweetName]?:java.util.TreeMap();
        for((time,count) in times.subMap(startTime,true,endTime,true)){
            val index=(time-startTime)/width;
            answer[index]+=count
        };
        return answer
    }
}
