class Solution {
    fun findLeastNumOfUniqueInts(arr:IntArray,k:Int):Int{
        val frequencies=arr.toList().groupingBy{
            it
        }.eachCount().values.sorted();
        var remaining=k;
        var unique=frequencies.size;
        for(frequency in frequencies){
            if(remaining<frequency)break;
            remaining-=frequency;
            unique--
        };
        return unique
    }
}
