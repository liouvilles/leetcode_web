const f=81,t="search-in-rotated-sorted-array-ii",e="Search in Rotated Sorted Array II",g="中等",i="数组与矩阵",l=["数组","二分查找"],o=!1,n="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/",s="搜索旋转排序数组 II",r=["二分查找","旋转数组","重复元素"],d="判断目标值是否存在于可能包含重复元素的旋转非递减数组中。",m="若左右端点与中点相同，无法判断有序侧，只能同时收缩；否则至少一侧有序，可据目标范围排除另一侧。",a=["重复元素会破坏普通旋转数组二分的判定","最坏情况下会退化为线性复杂度","范围比较要包含有序侧端点"],u=[{id:"duplicate-aware-binary-search",title:"跳过重复端点的二分",kind:"最优",idea:"先消除无法判断的三点相等情形，再利用有序半区定位目标。",steps:["比较 middle 是否命中","三点相等时左右同时收缩","判断有序侧及目标是否落在其中并缩小区间"],complexity:{time:"O(n) worst, O(log n) average",space:"O(1)"},code:{java:`class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { int middle = left + (right - left) / 2; if (nums[middle] == target) return true; if (nums[left] == nums[middle] && nums[middle] == nums[right]) { left++; right--; } else if (nums[left] <= nums[middle]) { if (nums[left] <= target && target < nums[middle]) right = middle - 1; else left = middle + 1; } else { if (nums[middle] < target && target <= nums[right]) left = middle + 1; else right = middle - 1; } }
        return false;
    }
}
`,kotlin:`class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0; var right = nums.lastIndex
        while (left <= right) { val middle = left + (right - left) / 2; if (nums[middle] == target) return true; if (nums[left] == nums[middle] && nums[middle] == nums[right]) { left++; right-- } else if (nums[left] <= nums[middle]) { if (nums[left] <= target && target < nums[middle]) right = middle - 1 else left = middle + 1 } else { if (nums[middle] < target && target <= nums[right]) left = middle + 1 else right = middle - 1 } }
        return false
    }
}
`,cpp:`class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) { int middle = left + (right - left) / 2; if (nums[middle] == target) return true; if (nums[left] == nums[middle] && nums[middle] == nums[right]) { ++left; --right; } else if (nums[left] <= nums[middle]) { if (nums[left] <= target && target < nums[middle]) right = middle - 1; else left = middle + 1; } else { if (nums[middle] < target && target <= nums[right]) left = middle + 1; else right = middle - 1; } } return false;
    }
};
`}}],c={id:81,slug:t,titleEn:e,difficulty:"中等",category:i,officialTags:l,paidOnly:!1,sourceUrl:n,title:s,studyTags:r,summary:d,insight:m,pitfalls:a,solutions:u};export{i as category,c as default,g as difficulty,f as id,m as insight,l as officialTags,o as paidOnly,a as pitfalls,t as slug,u as solutions,n as sourceUrl,r as studyTags,d as summary,s as title,e as titleEn};
