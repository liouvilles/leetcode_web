const c=209,t="minimum-size-subarray-sum",n="Minimum Size Subarray Sum",g="中等",s="数组与矩阵",i=["数组","二分查找","滑动窗口","前缀和"],f=!1,e="https://leetcode.cn/problems/minimum-size-subarray-sum/",r="长度最小的子数组",u=["滑动窗口","正数数组","最短合法区间"],m="在正整数数组中找到元素和至少为 target 的最短连续子数组长度，不存在则返回零。",l="所有元素为正，右端扩张只会增大和，达到目标后左端收缩只会减小和，因此窗口指针都单调移动。",a=["条件是和大于等于目标","每次合法时都要尝试继续收缩","没有合法窗口时返回零"],o=[{id:"sliding-window",title:"正数滑动窗口",kind:"最优",idea:"扩张右边界累加，窗口合法时反复移除左端并更新最短长度。",steps:["sum 加入当前右端值","sum>=target 时更新长度","减去左端值并右移 left"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, best = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) { sum += nums[right]; while (sum >= target) { best = Math.min(best, right - left + 1); sum -= nums[left++]; } }
        return best == Integer.MAX_VALUE ? 0 : best;
    }
}
`,kotlin:`class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0; var sum = 0; var best = Int.MAX_VALUE
        for (right in nums.indices) { sum += nums[right]; while (sum >= target) { best = minOf(best, right - left + 1); sum -= nums[left++] } }
        return if (best == Int.MAX_VALUE) 0 else best
    }
}
`,cpp:`class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0, sum = 0, best = INT_MAX;
        for (int right = 0; right < (int)nums.size(); ++right) { sum += nums[right]; while (sum >= target) { best = min(best, right - left + 1); sum -= nums[left++]; } }
        return best == INT_MAX ? 0 : best;
    }
};
`}}],b={id:209,slug:t,titleEn:n,difficulty:"中等",category:s,officialTags:i,paidOnly:!1,sourceUrl:e,title:r,studyTags:u,summary:m,insight:l,pitfalls:a,solutions:o};export{s as category,b as default,g as difficulty,c as id,l as insight,i as officialTags,f as paidOnly,a as pitfalls,t as slug,o as solutions,e as sourceUrl,u as studyTags,m as summary,r as title,n as titleEn};
