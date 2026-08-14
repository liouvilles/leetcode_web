const m=213,n="house-robber-ii",e="House Robber II",p="中等",t="动态规划",i=["数组","动态规划"],d=!1,r="https://leetcode.cn/problems/house-robber-ii/",s="打家劫舍 II",u=["环形动态规划","分类讨论","滚动状态"],o="房屋首尾相邻围成一圈，不能选择相邻房屋，求可获得的最大金额。",a="首尾不能同时选择，最优解一定属于“不选最后一间”或“不选第一间”两个线性问题之一。",l=["单间房屋需要单独处理","两个线性区间分别是 [0,n-2] 与 [1,n-1]","线性状态仍是相邻互斥"],c=[{id:"split-circle",title:"拆成两个线性区间",kind:"最优",idea:"分别计算排除首间和排除末间的线性打劫最优值并取最大。",steps:["单元素直接返回","滚动 DP 计算前 n-1 间","滚动 DP 计算后 n-1 间并取较大值"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(linear(nums, 0, nums.length - 2), linear(nums, 1, nums.length - 1));
    }
    private int linear(int[] nums, int start, int end) { int before = 0, previous = 0; for (int index = start; index <= end; index++) { int current = Math.max(previous, before + nums[index]); before = previous; previous = current; } return previous; }
}
`,kotlin:`class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(linear(nums, 0, nums.size - 2), linear(nums, 1, nums.lastIndex))
    }
    private fun linear(nums: IntArray, start: Int, end: Int): Int { var before = 0; var previous = 0; for (index in start..end) { val current = maxOf(previous, before + nums[index]); before = previous; previous = current }; return previous }
}
`,cpp:`class Solution {
    int linear(const vector<int>& nums, int start, int end) { int before = 0, previous = 0; for (int index = start; index <= end; ++index) { int current = max(previous, before + nums[index]); before = previous; previous = current; } return previous; }
public:
    int rob(vector<int>& nums) { if (nums.size() == 1) return nums[0]; return max(linear(nums, 0, nums.size() - 2), linear(nums, 1, nums.size() - 1)); }
};
`}}],f={id:213,slug:n,titleEn:e,difficulty:"中等",category:t,officialTags:i,paidOnly:!1,sourceUrl:r,title:s,studyTags:u,summary:o,insight:a,pitfalls:l,solutions:c};export{t as category,f as default,p as difficulty,m as id,a as insight,i as officialTags,d as paidOnly,l as pitfalls,n as slug,c as solutions,r as sourceUrl,u as studyTags,o as summary,s as title,e as titleEn};
