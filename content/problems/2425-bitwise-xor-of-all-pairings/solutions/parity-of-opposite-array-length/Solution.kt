class Solution {
    fun xorAllNums(nums1:IntArray,nums2:IntArray):Int{
        var answer=0;
        if(nums2.size%2==1)for(value in nums1)answer=answer xor value;
        if(nums1.size%2==1)for(value in nums2)answer=answer xor value;
        return answer
    }
}
