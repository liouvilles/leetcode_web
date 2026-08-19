class Solution {
    fun intersect(nums1:IntArray,nums2:IntArray):IntArray{
        nums1.sort();
        nums2.sort();
        val answer=mutableListOf<Int>();
        var i=0;
        var j=0;
        while(i<nums1.size&&j<nums2.size){
            if(nums1[i]==nums2[j]){
                answer.add(nums1[i]);
                i++;
                j++
            }else if(nums1[i]<nums2[j])i++ else j++
        };
        return answer.toIntArray()
    }
}
