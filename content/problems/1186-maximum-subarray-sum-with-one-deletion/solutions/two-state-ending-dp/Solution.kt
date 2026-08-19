class Solution {
    fun maximumSum(arr:IntArray):Int{
        var keep=arr[0];
        var removed=Int.MIN_VALUE/2;
        var answer=arr[0];
        for(i in 1 until arr.size){
            val nextRemoved=maxOf(removed+arr[i],keep);
            val nextKeep=maxOf(arr[i],keep+arr[i]);
            keep=nextKeep;
            removed=nextRemoved;
            answer=maxOf(answer,keep,removed)
        };
        return answer
    }
}
