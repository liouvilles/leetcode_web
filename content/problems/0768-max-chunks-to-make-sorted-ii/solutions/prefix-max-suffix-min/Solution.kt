class Solution {
    fun maxChunksToSorted(arr:IntArray):Int{
        val n=arr.size;
        val prefix=IntArray(n);
        val suffix=IntArray(n);
        prefix[0]=arr[0];
        for(i in 1 until n)prefix[i]=maxOf(prefix[i-1],arr[i]);
        suffix[n-1]=arr[n-1];
        for(i in n-2 downTo 0)suffix[i]=minOf(suffix[i+1],arr[i]);
        var answer=1;
        for(i in 0 until n-1)if(prefix[i]<=suffix[i+1])answer++;
        return answer
    }
}
