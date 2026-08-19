class Solution {
    fun arrayChange(nums:IntArray,operations:Array<IntArray>):IntArray{
        val position=HashMap<Int,Int>();
        for(i in nums.indices)position[nums[i]]=i;
        for(operation in operations){
            val index=position.remove(operation[0])!!;
            nums[index]=operation[1];
            position[operation[1]]=index
        };
        return nums
    }
}
