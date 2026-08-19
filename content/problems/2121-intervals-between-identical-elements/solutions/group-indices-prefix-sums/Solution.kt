class Solution {
    fun getDistances(arr:IntArray):LongArray{
        val groups=HashMap<Int,MutableList<Int>>();
        for(i in arr.indices)groups.getOrPut(arr[i]){
            mutableListOf()
        }.add(i);
        val answer=LongArray(arr.size);
        for(indices in groups.values){
            var total=indices.sumOf{
                it.toLong()
            };
            var left=0L;
            for(i in indices.indices){
                val index=indices[i];
                answer[index]=index.toLong()*i-left+(total-left-index)-index.toLong()*(indices.size-i-1);
                left+=index
            }
        };
        return answer
    }
}
