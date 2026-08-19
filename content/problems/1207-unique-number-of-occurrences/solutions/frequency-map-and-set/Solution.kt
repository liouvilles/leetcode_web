class Solution {
    fun uniqueOccurrences(arr:IntArray):Boolean{
        val frequency=mutableMapOf<Int,Int>();
        for(value in arr)frequency[value]=(frequency[value]?:0)+1;
        val seen=mutableSetOf<Int>();
        return frequency.values.all{
            seen.add(it)
        }
    }
}
