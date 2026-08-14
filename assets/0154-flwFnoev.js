const f=154,i="find-minimum-in-rotated-sorted-array-ii",t="Find Minimum in Rotated Sorted Array II",a="困难",e="数组与矩阵",n=["数组","二分查找"],g=!1,l="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/",d="寻找旋转排序数组中的最小值 II",s=["二分查找","旋转数组","重复元素"],r="在可能含重复元素的旋转非递减数组中找出最小元素。",m="比较中点与右端点：中点较大时最小值在右侧，较小时中点仍可能是答案；相等时只能安全丢弃一个右端点。",u=["重复值会使复杂度最坏退化为线性","middle 小于 right 时不能排除 middle","相等时不能直接跳过半个区间"],o=[{id:"right-boundary-binary-search",title:"与右端点比较的二分",kind:"最优",idea:"维持最小值位于闭区间内，并根据 middle 与 right 的关系收缩。",steps:["初始化 left=0,right=n-1","middle>rightValue 时 left=middle+1","middle<rightValue 时 right=middle，否则 right--"],complexity:{time:"O(n) worst, O(log n) average",space:"O(1)"},code:{java:`class Solution {
    public int findMin(int[] nums) { int left = 0, right = nums.length - 1; while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else if (nums[middle] < nums[right]) right = middle; else right--; } return nums[left]; }
}
`,kotlin:`class Solution {
    fun findMin(nums: IntArray): Int { var left = 0; var right = nums.lastIndex; while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1 else if (nums[middle] < nums[right]) right = middle else right-- }; return nums[left] }
}
`,cpp:`class Solution {
public:
    int findMin(vector<int>& nums) { int left = 0, right = nums.size() - 1; while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else if (nums[middle] < nums[right]) right = middle; else --right; } return nums[left]; }
};
`}}],h={id:154,slug:i,titleEn:t,difficulty:"困难",category:e,officialTags:n,paidOnly:!1,sourceUrl:l,title:d,studyTags:s,summary:r,insight:m,pitfalls:u,solutions:o};export{e as category,h as default,a as difficulty,f as id,m as insight,n as officialTags,g as paidOnly,u as pitfalls,i as slug,o as solutions,l as sourceUrl,s as studyTags,r as summary,d as title,t as titleEn};
