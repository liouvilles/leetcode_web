class Solution {
    fun numFactoredBinaryTrees(arr:IntArray):Int{
        arr.sort();
        val mod=1000000007L;
        var answer=0L;
        val ways=mutableMapOf<Int,Long>();
        for(i in arr.indices){
            var count=1L;
            for(j in 0 until i)if(arr[i]%arr[j]==0&&ways.containsKey(arr[i]/arr[j]))count=(count+ways[arr[j]]!!*ways[arr[i]/arr[j]]!!)%mod;
            ways[arr[i]]=count;
            answer=(answer+count)%mod
        };
        return answer.toInt()
    }
}
