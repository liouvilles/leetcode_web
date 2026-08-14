const l=53,n="maximum-subarray",t="Maximum Subarray",d="中等",s="动态规划",i=["数组","分治","动态规划"],p=!1,u="https://leetcode.cn/problems/maximum-subarray/",e="最大子数组和",r=["Kadane","以当前位置结尾","状态压缩"],a="在数组的所有非空连续片段中，求元素总和的最大值。",m="以 i 结尾的最优片段，要么只包含 nums[i]，要么接在以 i-1 结尾的最优片段之后。",c=["数组可能全为负数，答案不能初始化为 0","求的是连续片段","先更新当前状态再更新全局答案"],o=[{id:"dp-array",title:"动态规划数组",kind:"基础",idea:"dp[i] 表示必须以 i 结尾的最大子数组和，显式保存每个状态。",steps:["初始化 dp[0]","在重新开始与接续前一状态之间取最大值","扫描所有 dp 状态求全局最大值"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int best = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        var best = dp[0]
        for (i in 1 until nums.size) {
            dp[i] = maxOf(nums[i], dp[i - 1] + nums[i])
            best = maxOf(best, dp[i])
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> dp(nums.size());
        dp[0] = nums[0];
        int best = dp[0];
        for (int i = 1; i < (int)nums.size(); ++i) {
            dp[i] = max(nums[i], dp[i - 1] + nums[i]);
            best = max(best, dp[i]);
        }
        return best;
    }
};
`}},{id:"kadane",title:"Kadane 状态压缩",kind:"最优",idea:"当前状态只依赖前一个状态，因此用一个变量代替整个 dp 数组。",steps:["current 保存以上一位置结尾的最优和","决定接续还是从当前元素重启","同步维护 best"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }
}
`,kotlin:`class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var current = nums[0]
        var best = nums[0]
        for (i in 1 until nums.size) {
            current = maxOf(nums[i], current + nums[i])
            best = maxOf(best, current)
        }
        return best
    }
}
`,cpp:`class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int current = nums[0], best = nums[0];
        for (int i = 1; i < (int)nums.size(); ++i) {
            current = max(nums[i], current + nums[i]);
            best = max(best, current);
        }
        return best;
    }
};
`}}],b={id:53,slug:n,titleEn:t,difficulty:"中等",category:s,officialTags:i,paidOnly:!1,sourceUrl:u,title:e,studyTags:r,summary:a,insight:m,pitfalls:c,solutions:o};export{s as category,b as default,d as difficulty,l as id,m as insight,i as officialTags,p as paidOnly,c as pitfalls,n as slug,o as solutions,u as sourceUrl,r as studyTags,a as summary,e as title,t as titleEn};
