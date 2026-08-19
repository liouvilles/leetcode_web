class Solution {
    fun splitPainting(segments:Array<IntArray>):List<List<Long>>{
        val difference=java.util.TreeMap<Int,Long>();
        for(segment in segments){
            difference[segment[0]]=(difference[segment[0]]?:0)+segment[2];
            difference[segment[1]]=(difference[segment[1]]?:0)-segment[2]
        };
        val answer=mutableListOf<List<Long>>();
        var active=0L;
        var previous=0;
        var started=false;
        for((position,delta) in difference){
            if(started&&active!=0L&&previous<position)answer.add(listOf(previous.toLong(),position.toLong(),active));
            active+=delta;
            previous=position;
            started=true
        };
        return answer
    }
}
