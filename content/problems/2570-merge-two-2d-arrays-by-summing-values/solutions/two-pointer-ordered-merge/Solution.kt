class Solution {
    fun mergeArrays(nums1:Array<IntArray>,nums2:Array<IntArray>):Array<IntArray>{
        val answer=mutableListOf<IntArray>();
        var first=0;
        var second=0;
        while(first<nums1.size||second<nums2.size){
            if(second==nums2.size||first<nums1.size&&nums1[first][0]<nums2[second][0])answer.add(nums1[first++])else if(first==nums1.size||nums2[second][0]<nums1[first][0])answer.add(nums2[second++])else{
                answer.add(intArrayOf(nums1[first][0],nums1[first][1]+nums2[second][1]));
                first++;
                second++
            }
        };
        return answer.toTypedArray()
    }
}
