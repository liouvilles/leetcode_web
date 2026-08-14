const u=153,t="find-minimum-in-rotated-sorted-array",n="Find Minimum in Rotated Sorted Array",a="中等",i="数组与矩阵",e=["数组","二分查找"],c=!1,l="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/",s="寻找旋转排序数组中的最小值",d=["二分查找","旋转数组","右端比较"],r="在元素互不相同、经过若干次旋转的升序数组中找出最小元素。",m="把中点与右端比较：中点更大说明最小值在右侧，否则中点仍可能是答案，应保留在左半区。",o=["右边界更新为 middle 而不是 middle-1","未旋转数组也要正确处理","元素互不相同，因此没有相等分支的歧义"],f=[{id:"binary-search",title:"与右端比较的二分",kind:"最优",idea:"利用旋转后两段有序区间的相对大小定位断点。",steps:["维护包含最小值的闭区间","middle 大于 right 时移动 left","否则保留 middle 并收缩 right"],complexity:{time:"O(log n)",space:"O(1)"},code:{java:`class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else right = middle; }
        return nums[left];
    }
}
`,kotlin:`class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0; var right = nums.lastIndex
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1 else right = middle }
        return nums[left]
    }
}
`,cpp:`class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else right = middle; }
        return nums[left];
    }
};
`}}],g={id:153,slug:t,titleEn:n,difficulty:"中等",category:i,officialTags:e,paidOnly:!1,sourceUrl:l,title:s,studyTags:d,summary:r,insight:m,pitfalls:o,solutions:f};export{i as category,g as default,a as difficulty,u as id,m as insight,e as officialTags,c as paidOnly,o as pitfalls,t as slug,f as solutions,l as sourceUrl,d as studyTags,r as summary,s as title,n as titleEn};
