class Solution {
    fun fourSumCount(nums1:IntArray,nums2:IntArray,nums3:IntArray,nums4:IntArray):Int{
        val counts=hashMapOf<Int,Int>();
        for(a in nums1)for(b in nums2)counts[a+b]=(counts[a+b]?:0)+1;
        var answer=0;
        for(c in nums3)for(d in nums4)answer+=counts[-c-d]?:0;
        return answer
    }
}
