class Solution {
    fun maximumBags(capacity:IntArray,rocks:IntArray,additionalRocksValue:Int):Int{
        val deficits=IntArray(capacity.size){
            capacity[it]-rocks[it]
        };
        deficits.sort();
        var remaining=additionalRocksValue;
        var answer=0;
        for(deficit in deficits){
            if(deficit>remaining)break;
            remaining-=deficit;
            answer++
        };
        return answer
    }
}
