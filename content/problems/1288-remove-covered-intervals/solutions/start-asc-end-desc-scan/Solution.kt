class Solution {
    fun removeCoveredIntervals(intervals:Array<IntArray>):Int{
        intervals.sortWith(compareBy<IntArray>{
            it[0]
        }.thenByDescending{
            it[1]
        });
        var maximumEnd=Int.MIN_VALUE;
        var remaining=0;
        for(interval in intervals)if(interval[1]>maximumEnd){
            remaining++;
            maximumEnd=interval[1]
        };
        return remaining
    }
}
