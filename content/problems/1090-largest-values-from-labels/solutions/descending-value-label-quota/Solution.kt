class Solution {
    fun largestValsFromLabels(values:IntArray,labels:IntArray,numWanted:Int,useLimit:Int):Int{
        val order=values.indices.sortedByDescending{
            values[it]
        };
        val used=mutableMapOf<Int,Int>();
        var sum=0;
        var selected=0;
        for(index in order)if((used[labels[index]]?:0)<useLimit){
            sum+=values[index];
            used[labels[index]]=(used[labels[index]]?:0)+1;
            if(++selected==numWanted)break
        };
        return sum
    }
}
