class Solution {
    fun xorQueries(arr:IntArray,queries:Array<IntArray>):IntArray{
        val prefix=IntArray(arr.size+1);
        for(i in arr.indices)prefix[i+1]=prefix[i] xor arr[i];
        return IntArray(queries.size){
            prefix[queries[it][1]+1] xor prefix[queries[it][0]]
        }
    }
}
