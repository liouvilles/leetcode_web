class Solution {
    fun distinctDifferenceArray(nums:IntArray):IntArray{
        val suffix=HashMap<Int,Int>();
        for(value in nums)suffix[value]=suffix.getOrDefault(value,0)+1;
        val prefix=HashSet<Int>();
        return IntArray(nums.size){
            index->val value=nums[index];
            val remaining=suffix[value]!!-1;
            if(remaining==0)suffix.remove(value) else suffix[value]=remaining;
            prefix.add(value);
            prefix.size-suffix.size
        }
    }
}
