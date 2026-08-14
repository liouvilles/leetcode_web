const p=416,t="partition-equal-subset-sum",n="Partition Equal Subset Sum",m="中等",s="动态规划",e=["数组","动态规划","背包问题","0-1 背包"],b=!1,r="https://leetcode.cn/problems/partition-equal-subset-sum/",u="分割等和子集",o=["0-1 背包","可达性 DP","倒序枚举"],i="判断正整数数组能否划分为两个元素和相等的子集。",l="总和必须为偶数，问题等价于是否能从每个元素至多选一次凑出总和的一半。",a=["总和为奇数可直接失败","容量必须倒序更新以防重复使用当前元素","dp[0] 初始为真"],c=[{id:"zero-one-knapsack",title:"一维 0-1 背包",kind:"最优",idea:"布尔数组记录使用已处理元素能否凑出每个容量。",steps:["计算总和并排除奇数","target=sum/2 且 possible[0]=true","对每个值从 target 倒序更新"],complexity:{time:"O(n·sum)",space:"O(sum)"},code:{java:`class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; for (int value : nums) sum += value; if ((sum & 1) == 1) return false;
        int target = sum / 2; boolean[] possible = new boolean[target + 1]; possible[0] = true;
        for (int value : nums) for (int current = target; current >= value; current--) possible[current] |= possible[current - value];
        return possible[target];
    }
}
`,kotlin:`class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum(); if (sum % 2 != 0) return false
        val target = sum / 2; val possible = BooleanArray(target + 1); possible[0] = true
        for (value in nums) for (current in target downTo value) possible[current] = possible[current] || possible[current - value]
        return possible[target]
    }
}
`,cpp:`class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0); if (sum & 1) return false;
        int target = sum / 2; vector<bool> possible(target + 1); possible[0] = true;
        for (int value : nums) for (int current = target; current >= value; --current) possible[current] = possible[current] || possible[current - value];
        return possible[target];
    }
};
`}}],f={id:416,slug:t,titleEn:n,difficulty:"中等",category:s,officialTags:e,paidOnly:!1,sourceUrl:r,title:u,studyTags:o,summary:i,insight:l,pitfalls:a,solutions:c};export{s as category,f as default,m as difficulty,p as id,l as insight,e as officialTags,b as paidOnly,a as pitfalls,t as slug,c as solutions,r as sourceUrl,o as studyTags,i as summary,u as title,n as titleEn};
