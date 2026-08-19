class Solution {
    fun numberOfPairs(points:Array<IntArray>):Int{
        points.sortWith(compareBy<IntArray>{
            it[0]
        }.thenByDescending{
            it[1]
        });
        var answer=0;
        for(alice in points.indices){
            var lowestVisible=Int.MIN_VALUE;
            for(bob in alice+1 until points.size)if(points[bob][1]<=points[alice][1]&&points[bob][1]>lowestVisible){
                answer++;
                lowestVisible=points[bob][1]
            }
        };
        return answer
    }
}
