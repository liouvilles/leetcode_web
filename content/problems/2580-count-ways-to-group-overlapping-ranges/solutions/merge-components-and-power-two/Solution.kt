class Solution {
    fun countWays(ranges:Array<IntArray>):Int{
        ranges.sortBy{
            it[0]
        };
        var components=0;
        var end=-1;
        for(range in ranges){
            if(range[0]>end){
                components++;
                end=range[1]
            }else end=maxOf(end,range[1])
        };
        var answer=1L;
        repeat(components){
            answer=answer*2%1_000_000_007
        };
        return answer.toInt()
    }
}
