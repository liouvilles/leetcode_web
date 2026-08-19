class Solution {
    fun minOperations(nums1:IntArray,nums2:IntArray,k:Int):Long{
        if(k==0)return if(nums1.contentEquals(nums2))0 else -1;
        var positive=0L;
        var negative=0L;
        for(i in nums1.indices){
            val difference=nums1[i]-nums2[i];
            if(difference%k!=0)return -1;
            if(difference>0)positive+=difference/k else negative-=difference/k
        };
        return if(positive==negative)positive else -1
    }
}
