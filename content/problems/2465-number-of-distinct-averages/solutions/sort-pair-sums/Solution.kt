class Solution {
    fun distinctAverages(nums:IntArray):Int{
        nums.sort();
        val sums=HashSet<Int>();
        var left=0;
        var right=nums.lastIndex;
        while(left<right)sums.add(nums[left++]+nums[right--]);
        return sums.size
    }
}
