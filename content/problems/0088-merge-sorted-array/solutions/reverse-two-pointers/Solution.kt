class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var first = m - 1; var second = n - 1; var write = m + n - 1
        while (second >= 0) nums1[write--] = if (first >= 0 && nums1[first] > nums2[second]) nums1[first--] else nums2[second--]
    }
}
