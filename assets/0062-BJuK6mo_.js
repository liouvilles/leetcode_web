const r=62,n="unique-paths",t="Unique Paths",m="中等",o="动态规划",s=["数学","动态规划","组合数学"],h=!1,i="https://leetcode.cn/problems/unique-paths/",l="不同路径",c=["网格动态规划","状态压缩","路径计数"],u="机器人从网格左上角出发，每次只能向右或向下移动，计算到达右下角的不同路径数量。",a="到达一个格子的最后一步只能来自上方或左方，因此路径数是这两个方向路径数之和。",p=["第一行和第一列都只有一种到达方式","更新一维数组时 dp[column] 仍代表上方路径数","题目计算路径数量而不是最短步数"],e=[{id:"one-dimensional-dp",title:"一维动态规划",kind:"最优",idea:"用一行数组保存当前行每个格子的路径数，原值代表上方，左侧值代表左方。",steps:["把第一行初始化为全 1","从第二行开始由左向右更新","执行 dp[col] += dp[col - 1]"],complexity:{time:"O(mn)",space:"O(n)"},code:{java:`class Solution {
    public int uniquePaths(int m, int n) {
        int[] paths = new int[n];
        Arrays.fill(paths, 1);
        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                paths[column] += paths[column - 1];
            }
        }
        return paths[n - 1];
    }
}
`,kotlin:`class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val paths = IntArray(n) { 1 }
        for (row in 1 until m) {
            for (column in 1 until n) {
                paths[column] += paths[column - 1]
            }
        }
        return paths[n - 1]
    }
}
`,cpp:`class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> paths(n, 1);
        for (int row = 1; row < m; ++row) {
            for (int column = 1; column < n; ++column) {
                paths[column] += paths[column - 1];
            }
        }
        return paths[n - 1];
    }
};
`}}],d={id:62,slug:n,titleEn:t,difficulty:"中等",category:o,officialTags:s,paidOnly:!1,sourceUrl:i,title:l,studyTags:c,summary:u,insight:a,pitfalls:p,solutions:e};export{o as category,d as default,m as difficulty,r as id,a as insight,s as officialTags,h as paidOnly,p as pitfalls,n as slug,e as solutions,i as sourceUrl,c as studyTags,u as summary,l as title,t as titleEn};
