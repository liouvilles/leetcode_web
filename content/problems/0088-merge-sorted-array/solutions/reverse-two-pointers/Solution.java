class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1, second = n - 1, write = m + n - 1;
        while (second >= 0) nums1[write--] = first >= 0 && nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
    }
}
