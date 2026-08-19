class Solution {
    fun earliestFullBloom(plantTime:IntArray,growTime:IntArray):Int{
        val order=plantTime.indices.sortedByDescending{
            growTime[it]
        };
        var elapsed=0;
        var answer=0;
        for(index in order){
            elapsed+=plantTime[index];
            answer=maxOf(answer,elapsed+growTime[index])
        };
        return answer
    }
}
