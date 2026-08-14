const f=34,t="find-first-and-last-position-of-element-in-sorted-array",n="Find First and Last Position of Element in Sorted Array",g="中等",e="数组与矩阵",r=["数组","二分查找"],m=!1,i="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/",s="在排序数组中查找元素的第一个和最后一个位置",l=["二分边界","lower bound","闭开区间"],o="在非递减数组中返回目标值第一次和最后一次出现的下标，不存在时返回 [-1,-1]。",a="分别查找第一个不小于 target 和第一个大于 target 的位置，就能得到目标区间。",u=["第二个边界是 target + 1 的 lower bound 语义","要先验证左边界确实命中目标","空数组同样适用"],d=[{id:"two-lower-bounds",title:"两次边界二分",kind:"最优",idea:"统一实现首个不小于给定值的位置，分别求左右边界。",steps:["求 lowerBound(target)","检查是否越界或未命中","求 lowerBound(target + 1) 并减一"],complexity:{time:"O(log n)",space:"O(1)"},code:{java:`class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if (first == nums.length || nums[first] != target) return new int[] {-1, -1};
        return new int[] {first, lowerBound(nums, target + 1L) - 1};
    }
    private int lowerBound(int[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) left = middle + 1; else right = middle;
        }
        return left;
    }
}
`,kotlin:`class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = lowerBound(nums, target.toLong())
        if (first == nums.size || nums[first] != target) return intArrayOf(-1, -1)
        return intArrayOf(first, lowerBound(nums, target.toLong() + 1) - 1)
    }
    private fun lowerBound(nums: IntArray, target: Long): Int {
        var left = 0
        var right = nums.size
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle].toLong() < target) left = middle + 1 else right = middle }
        return left
    }
}
`,cpp:`class Solution {
    int lowerBound(const vector<int>& nums, long long target) {
        int left = 0, right = nums.size();
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1; else right = middle; }
        return left;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = lowerBound(nums, target);
        if (first == (int)nums.size() || nums[first] != target) return {-1, -1};
        return {first, lowerBound(nums, (long long)target + 1) - 1};
    }
};
`}}],c={id:34,slug:t,titleEn:n,difficulty:"中等",category:e,officialTags:r,paidOnly:!1,sourceUrl:i,title:s,studyTags:l,summary:o,insight:a,pitfalls:u,solutions:d};export{e as category,c as default,g as difficulty,f as id,a as insight,r as officialTags,m as paidOnly,u as pitfalls,t as slug,d as solutions,i as sourceUrl,l as studyTags,o as summary,s as title,n as titleEn};
