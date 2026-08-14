const f=35,t="search-insert-position",n="Search Insert Position",u="简单",e="数组与矩阵",i=["数组","二分查找"],m=!1,l="https://leetcode.cn/problems/search-insert-position/",s="搜索插入位置",r=["二分查找","插入边界","lower bound"],o="在严格递增数组中查找目标值；若不存在，返回它按顺序插入后应处于的下标。",d="答案就是第一个大于或等于目标值的位置，也可能等于数组长度。",c=["右边界设为数组长度才能表示尾部插入","目标存在时仍返回其原下标","循环维持左闭右开区间"],a=[{id:"lower-bound",title:"左闭右开二分",kind:"最优",idea:"查找第一个不小于目标值的位置。",steps:["初始化 [0,n) 区间","中间值小于目标时舍弃左半部分","否则保留中点并收缩右边界"],complexity:{time:"O(log n)",space:"O(1)"},code:{java:`class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1; else right = middle; }
        return left;
    }
}
`,kotlin:`class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1 else right = middle }
        return left
    }
}
`,cpp:`class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0, right = nums.size();
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1; else right = middle; }
        return left;
    }
};
`}}],g={id:35,slug:t,titleEn:n,difficulty:"简单",category:e,officialTags:i,paidOnly:!1,sourceUrl:l,title:s,studyTags:r,summary:o,insight:d,pitfalls:c,solutions:a};export{e as category,g as default,u as difficulty,f as id,d as insight,i as officialTags,m as paidOnly,c as pitfalls,t as slug,a as solutions,l as sourceUrl,r as studyTags,o as summary,s as title,n as titleEn};
