class Solution {
    fun singleNonDuplicate(nums:IntArray):Int{
        var left=0;
        var right=nums.lastIndex;
        while(left<right){
            var middle=left+(right-left)/2;
            if(middle%2==1)middle--;
            if(nums[middle]==nums[middle+1])left=middle+2 else right=middle
        };
        return nums[left]
    }
}
