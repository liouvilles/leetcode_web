class Solution {
    fun sumOddLengthSubarrays(arr:IntArray):Int{
        var answer=0;
        for(i in arr.indices){
            val total=(i+1)*(arr.size-i);
            answer+=arr[i]*((total+1)/2)
        };
        return answer
    }
}
