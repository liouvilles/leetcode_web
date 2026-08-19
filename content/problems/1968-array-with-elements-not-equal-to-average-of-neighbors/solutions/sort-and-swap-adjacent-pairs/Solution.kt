class Solution {
    fun rearrangeArray(nums:IntArray):IntArray{
        nums.sort();
        var i=1;
        while(i+1<nums.size){
            val temporary=nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temporary;
            i+=2
        };
        return nums
    }
}
