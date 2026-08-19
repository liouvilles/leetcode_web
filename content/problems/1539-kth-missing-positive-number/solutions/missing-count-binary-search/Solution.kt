class Solution {
    fun findKthPositive(arr:IntArray,k:Int):Int{
        var left=0;
        var right=arr.size;
        while(left<right){
            val middle=left+(right-left)/2;
            if(arr[middle]-middle-1<k)left=middle+1 else right=middle
        };
        return left+k
    }
}
