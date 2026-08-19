class Solution {
    fun minIncrementForUnique(nums:IntArray):Int{
        nums.sort();
        var moves=0;
        for(i in 1 until nums.size)if(nums[i]<=nums[i-1]){
            val required=nums[i-1]+1;
            moves+=required-nums[i];
            nums[i]=required
        };
        return moves
    }
}
