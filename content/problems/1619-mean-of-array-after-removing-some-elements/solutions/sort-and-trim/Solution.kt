class Solution {
    fun trimMean(arr:IntArray):Double{
        arr.sort();
        val trim=arr.size/20;
        var sum=0.0;
        for(i in trim until arr.size-trim)sum+=arr[i];
        return sum/(arr.size-2*trim)
    }
}
