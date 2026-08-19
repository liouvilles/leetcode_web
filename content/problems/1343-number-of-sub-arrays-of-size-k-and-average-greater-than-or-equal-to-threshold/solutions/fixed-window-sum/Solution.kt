class Solution {
    fun numOfSubarrays(arr:IntArray,k:Int,threshold:Int):Int{
        var sum=0;
        var answer=0;
        val target=k*threshold;
        for(right in arr.indices){
            sum+=arr[right];
            if(right>=k)sum-=arr[right-k];
            if(right>=k-1&&sum>=target)answer++
        };
        return answer
    }
}
