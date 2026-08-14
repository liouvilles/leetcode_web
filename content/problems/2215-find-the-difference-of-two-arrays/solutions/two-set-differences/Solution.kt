class Solution { fun findDifference(nums1:IntArray,nums2:IntArray):List<List<Int>>{val first=nums1.toSet();val second=nums2.toSet();return listOf((first-second).sorted(),(second-first).sorted())} }
