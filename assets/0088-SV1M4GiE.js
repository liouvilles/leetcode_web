const l=88,n="merge-sorted-array",s="Merge Sorted Array",a="简单",t="数组与矩阵",i=["数组","双指针","排序"],f=!1,e="https://leetcode.cn/problems/merge-sorted-array/",o="合并两个有序数组",r=["逆向双指针","原地合并","尾部写入"],m="把两个非递减数组合并进第一个数组；第一个数组尾部已经预留足够空间。",c="从两个有效区间的末尾比较，把较大值写到预留空间末尾，就不会覆盖尚未读取的数据。",u=["nums1 只有前 m 个元素有效","nums2 剩余元素必须复制","nums1 剩余元素已经在正确位置无需处理"],d=[{id:"reverse-two-pointers",title:"尾部逆向合并",kind:"最优",idea:"三个指针从后向前选择较大元素写入 nums1。",steps:["first=m-1、second=n-1、write=m+n-1","比较两个末尾并写入较大值","循环直到 nums2 全部写入"],complexity:{time:"O(m+n)",space:"O(1)"},code:{java:`class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1, second = n - 1, write = m + n - 1;
        while (second >= 0) nums1[write--] = first >= 0 && nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
    }
}
`,kotlin:`class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var first = m - 1; var second = n - 1; var write = m + n - 1
        while (second >= 0) nums1[write--] = if (first >= 0 && nums1[first] > nums2[second]) nums1[first--] else nums2[second--]
    }
}
`,cpp:`class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int first = m - 1, second = n - 1, write = m + n - 1;
        while (second >= 0) nums1[write--] = first >= 0 && nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
    }
};
`}}],p={id:88,slug:n,titleEn:s,difficulty:"简单",category:t,officialTags:i,paidOnly:!1,sourceUrl:e,title:o,studyTags:r,summary:m,insight:c,pitfalls:u,solutions:d};export{t as category,p as default,a as difficulty,l as id,c as insight,i as officialTags,f as paidOnly,u as pitfalls,n as slug,d as solutions,e as sourceUrl,r as studyTags,m as summary,o as title,s as titleEn};
