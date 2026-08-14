const u=33,t="search-in-rotated-sorted-array",e="Search in Rotated Sorted Array",g="中等",n="数组与矩阵",i=["数组","二分查找"],o=!1,l="https://leetcode.cn/problems/search-in-rotated-sorted-array/",s="搜索旋转排序数组",d=["二分查找","有序半区","旋转数组"],r="在一个元素互不相同、经过未知位置旋转的升序数组中查找目标值下标，不存在时返回 -1。",m="任意二分区间至少有一半仍然有序，判断目标是否落在该有序半区即可排除另一半。",a=["边界比较要统一使用闭区间","先确定哪一半有序，再判断目标范围","目标不存在时必须返回 -1"],f=[{id:"modified-binary-search",title:"识别有序半区的二分",kind:"最优",idea:"每轮利用端点和中点识别有序的一半，再根据目标范围缩小搜索区间。",steps:["计算中点并直接检查目标","比较左端与中点判断左半区是否有序","依据目标是否位于有序范围更新左右边界"],complexity:{time:"O(log n)",space:"O(1)"},code:{java:`class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            } else {
                if (nums[middle] < target && target <= nums[right]) left = middle + 1;
                else right = middle - 1;
            }
        }
        return -1;
    }
}
`,kotlin:`class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val middle = left + (right - left) / 2
            if (nums[middle] == target) return middle
            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target < nums[middle]) right = middle - 1
                else left = middle + 1
            } else {
                if (target > nums[middle] && target <= nums[right]) left = middle + 1
                else right = middle - 1
            }
        }
        return -1
    }
}
`,cpp:`class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = (int)nums.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            } else {
                if (nums[middle] < target && target <= nums[right]) left = middle + 1;
                else right = middle - 1;
            }
        }
        return -1;
    }
};
`}}],c={id:33,slug:t,titleEn:e,difficulty:"中等",category:n,officialTags:i,paidOnly:!1,sourceUrl:l,title:s,studyTags:d,summary:r,insight:m,pitfalls:a,solutions:f};export{n as category,c as default,g as difficulty,u as id,m as insight,i as officialTags,o as paidOnly,a as pitfalls,t as slug,f as solutions,l as sourceUrl,d as studyTags,r as summary,s as title,e as titleEn};
