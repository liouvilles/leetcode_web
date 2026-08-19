class Solution {
    fun findLongestChain(pairs:Array<IntArray>):Int{
        pairs.sortBy{
            it[1]
        };
        var end=Int.MIN_VALUE;
        var length=0;
        for(pair in pairs)if(pair[0]>end){
            length++;
            end=pair[1]
        };
        return length
    }
}
