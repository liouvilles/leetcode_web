class NumArray(nums:IntArray){
    private val prefix=IntArray(nums.size+1);
    init{
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i]
    }
    fun sumRange(left:Int,right:Int):Int=prefix[right+1]-prefix[left]
}
