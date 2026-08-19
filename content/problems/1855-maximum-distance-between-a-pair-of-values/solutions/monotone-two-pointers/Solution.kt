class Solution {
    fun maxDistance(nums1:IntArray,nums2:IntArray):Int{
        var first=0;
        var second=0;
        var answer=0;
        while(first<nums1.size&&second<nums2.size){
            second=maxOf(second,first);
            if(second>=nums2.size)break;
            if(nums1[first]<=nums2[second]){
                answer=maxOf(answer,second-first);
                second++
            }else first++
        };
        return answer
    }
}
