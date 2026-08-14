const v=279,n="perfect-squares",t="Perfect Squares",p="中等",o="动态规划",u=["数学","动态规划","广度优先搜索","背包问题","完全背包"],d=!1,e="https://leetcode.cn/problems/perfect-squares/",a="完全平方数",l=["完全背包","动态规划","最少数量"],c="求若干个完全平方数之和等于 n 时所需的最少项数，每个平方数可以重复使用。",r="把每个平方数视为可无限使用的物品，dp[value] 从所有 dp[value-square]+1 中取最小。",s=["一也属于完全平方数，因此一定有解","平方数可重复使用","状态初始值要大于任何可能答案"],i=[{id:"complete-knapsack-dp",title:"最短组成动态规划",kind:"最优",idea:"从一到 n 依次计算每个整数的最少平方数数量。",steps:["dp[0]=0，其余初始化较大值","枚举 value 的所有 square<=value","更新 dp[value]=min(dp[value],dp[value-square]+1)"],complexity:{time:"O(n√n)",space:"O(n)"},code:{java:`class Solution {
    public int numSquares(int n) {
        int[] count = new int[n + 1]; Arrays.fill(count, n + 1); count[0] = 0;
        for (int value = 1; value <= n; value++) for (int root = 1; root * root <= value; root++) count[value] = Math.min(count[value], count[value - root * root] + 1);
        return count[n];
    }
}
`,kotlin:`class Solution {
    fun numSquares(n: Int): Int {
        val count = IntArray(n + 1) { n + 1 }; count[0] = 0
        for (value in 1..n) { var root = 1; while (root * root <= value) { count[value] = minOf(count[value], count[value - root * root] + 1); root++ } }
        return count[n]
    }
}
`,cpp:`class Solution {
public:
    int numSquares(int n) {
        vector<int> count(n + 1, n + 1); count[0] = 0;
        for (int value = 1; value <= n; ++value) for (int root = 1; root * root <= value; ++root) count[value] = min(count[value], count[value - root * root] + 1);
        return count[n];
    }
};
`}}],f={id:279,slug:n,titleEn:t,difficulty:"中等",category:o,officialTags:u,paidOnly:!1,sourceUrl:e,title:a,studyTags:l,summary:c,insight:r,pitfalls:s,solutions:i};export{o as category,f as default,p as difficulty,v as id,r as insight,u as officialTags,d as paidOnly,s as pitfalls,n as slug,i as solutions,e as sourceUrl,l as studyTags,c as summary,a as title,t as titleEn};
