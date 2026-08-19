class Solution {
    fun numSubarrayBoundedMax(nums:IntArray,left:Int,right:Int):Int=atMost(nums,right)-atMost(nums,left-1);
    private fun atMost(nums:IntArray,bound:Int):Int{
        var result=0;
        var length=0;
        for(value in nums){
            length=if(value<=bound)length+1 else 0;
            result+=length
        };
        return result
    }
}
