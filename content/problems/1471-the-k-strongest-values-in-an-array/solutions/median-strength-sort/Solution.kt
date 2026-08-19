class Solution {
    fun getStrongest(arr:IntArray,k:Int):IntArray{
        arr.sort();
        val median=arr[(arr.size-1)/2];
        return arr.toList().sortedWith(compareByDescending<Int>{
            kotlin.math.abs(it-median)
        }.thenByDescending{
            it
        }).take(k).toIntArray()
    }
}
