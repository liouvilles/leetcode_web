class Solution {
    private fun lower(values:IntArray,target:Long):Int{
        var left=0;
        var right=values.size;
        while(left<right){
            val middle=(left+right)/2;
            if(values[middle]<target)left=middle+1 else right=middle
        };
        return left
    };
    private fun upper(values:IntArray,target:Long):Int{
        var left=0;
        var right=values.size;
        while(left<right){
            val middle=(left+right)/2;
            if(values[middle]<=target)left=middle+1 else right=middle
        };
        return left
    };
    private fun floorDiv(a:Long,b:Long)=java.lang.Math.floorDiv(a,b);
    private fun count(first:IntArray,second:IntArray,limit:Long):Long{
        var result=0L;
        for(value in first)when{
            value>0->result+=upper(second,floorDiv(limit,value.toLong()));
            value<0->{
                val ceiling=-floorDiv(-limit,value.toLong());
                result+=second.size-lower(second,ceiling)
            };
            limit>=0->result+=second.size
        };
        return result
    };
    fun kthSmallestProduct(nums1:IntArray,nums2:IntArray,k:Long):Long{
        var left=-10_000_000_000L;
        var right=10_000_000_000L;
        while(left<right){
            val middle=left+(right-left)/2;
            if(count(nums1,nums2,middle)>=k)right=middle else left=middle+1
        };
        return left
    }
}
