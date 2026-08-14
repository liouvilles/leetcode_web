const f=16,t="3sum-closest",s="3Sum Closest",g="中等",n="数组与矩阵",e=["数组","双指针","排序"],c=!1,i="https://leetcode.cn/problems/3sum-closest/",r="最接近的三数之和",u=["排序","双指针","距离更新"],l="从整数数组中选择三个不同位置，使三数之和与目标值最接近，并返回该和。",o="排序后固定一个数，用双指针按当前和与目标的大小单调移动，并持续更新绝对距离更小的和。",m=["返回的是三数之和而不是距离","恰好命中目标可立即返回","比较距离时用长整型更稳妥"],a=[{id:"sort-two-pointers",title:"排序 + 双指针",kind:"最优",idea:"固定首元素后在线性区间内寻找最接近目标的两数和。",steps:["数组排序并初始化 best","枚举 first，左右指针求当前和","距离更小时更新；和偏小左移，偏大右移"],complexity:{time:"O(n²)",space:"O(log n)"},code:{java:`class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); int best = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length - 2; first++) { int left = first + 1, right = nums.length - 1; while (left < right) { int sum = nums[first] + nums[left] + nums[right]; if (Math.abs((long)sum - target) < Math.abs((long)best - target)) best = sum; if (sum == target) return target; if (sum < target) left++; else right--; } }
        return best;
    }
}
`,kotlin:`class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort(); var best = nums[0] + nums[1] + nums[2]
        for (first in 0 until nums.size - 2) { var left = first + 1; var right = nums.lastIndex; while (left < right) { val sum = nums[first] + nums[left] + nums[right]; if (kotlin.math.abs(sum.toLong() - target) < kotlin.math.abs(best.toLong() - target)) best = sum; if (sum == target) return target; if (sum < target) left++ else right-- } }
        return best
    }
}
`,cpp:`class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end()); int best = nums[0] + nums[1] + nums[2];
        for (int first = 0; first + 2 < (int)nums.size(); ++first) { int left = first + 1, right = nums.size() - 1; while (left < right) { int sum = nums[first] + nums[left] + nums[right]; if (llabs((long long)sum - target) < llabs((long long)best - target)) best = sum; if (sum == target) return target; if (sum < target) ++left; else --right; } }
        return best;
    }
};
`}}],h={id:16,slug:t,titleEn:s,difficulty:"中等",category:n,officialTags:e,paidOnly:!1,sourceUrl:i,title:r,studyTags:u,summary:l,insight:o,pitfalls:m,solutions:a};export{n as category,h as default,g as difficulty,f as id,o as insight,e as officialTags,c as paidOnly,m as pitfalls,t as slug,a as solutions,i as sourceUrl,u as studyTags,l as summary,r as title,s as titleEn};
