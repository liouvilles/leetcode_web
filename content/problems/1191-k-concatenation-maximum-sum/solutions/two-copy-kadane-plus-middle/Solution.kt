class Solution {
    fun kConcatenationMaxSum(arr:IntArray,k:Int):Int{
        val total=arr.sumOf{
            it.toLong()
        };
        var ending=0L;
        var best=0L;
        repeat(minOf(k,2)){
            for(value in arr){
                ending=maxOf(0L,ending+value);
                best=maxOf(best,ending)
            }
        };
        if(k>2&&total>0)best+=(k-2L)*total;
        return (best%1000000007L).toInt()
    }
}
