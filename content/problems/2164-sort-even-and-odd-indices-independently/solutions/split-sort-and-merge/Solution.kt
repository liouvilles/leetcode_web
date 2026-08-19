class Solution {
    fun sortEvenOdd(nums:IntArray):IntArray{
        val even=nums.filterIndexed{
            index,_->index%2==0
        }.sorted();
        val odd=nums.filterIndexed{
            index,_->index%2==1
        }.sortedDescending();
        var e=0;
        var o=0;
        for(i in nums.indices)nums[i]=if(i%2==0)even[e++]else odd[o++];
        return nums
    }
}
