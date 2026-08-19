class Solution {
    fun peakIndexInMountainArray(arr:IntArray):Int{
        var low=0;
        var high=arr.lastIndex;
        while(low<high){
            val middle=low+(high-low)/2;
            if(arr[middle]<arr[middle+1])low=middle+1 else high=middle
        };
        return low
    }
}
