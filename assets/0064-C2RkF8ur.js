const d=64,n="minimum-path-sum",o="Minimum Path Sum",a="中等",t="动态规划",c=["数组","动态规划","矩阵"],g=!1,i="https://leetcode.cn/problems/minimum-path-sum/",s="最小路径和",l=["网格动态规划","状态压缩","最优子结构"],r="从非负整数网格左上角出发，每次向右或向下，求到右下角路径上的最小数字总和。",u="到达当前格子的最小代价等于当前值加上方和左方代价中的较小者。",m=["起点值必须计入总和","第一行只能从左侧到达","第一列只能从上方到达"],e=[{id:"one-row-dp",title:"一维网格 DP",kind:"最优",idea:"用一行数组复用上方代价，并用刚更新的左侧值完成转移。",steps:["初始化第一行的前缀和","逐行更新第一列","其余位置加上上方和左方最小值"],complexity:{time:"O(mn)",space:"O(n)"},code:{java:`class Solution {
    public int minPathSum(int[][] grid) {
        int[] cost = new int[grid[0].length];
        cost[0] = grid[0][0];
        for (int column = 1; column < cost.length; column++) cost[column] = cost[column - 1] + grid[0][column];
        for (int row = 1; row < grid.length; row++) {
            cost[0] += grid[row][0];
            for (int column = 1; column < cost.length; column++) cost[column] = Math.min(cost[column], cost[column - 1]) + grid[row][column];
        }
        return cost[cost.length - 1];
    }
}
`,kotlin:`class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val cost = IntArray(grid[0].size)
        cost[0] = grid[0][0]
        for (column in 1 until cost.size) cost[column] = cost[column - 1] + grid[0][column]
        for (row in 1 until grid.size) { cost[0] += grid[row][0]; for (column in 1 until cost.size) cost[column] = minOf(cost[column], cost[column - 1]) + grid[row][column] }
        return cost.last()
    }
}
`,cpp:`class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        vector<int> cost(grid[0].size());
        cost[0] = grid[0][0];
        for (int column = 1; column < (int)cost.size(); ++column) cost[column] = cost[column - 1] + grid[0][column];
        for (int row = 1; row < (int)grid.size(); ++row) { cost[0] += grid[row][0]; for (int column = 1; column < (int)cost.size(); ++column) cost[column] = min(cost[column], cost[column - 1]) + grid[row][column]; }
        return cost.back();
    }
};
`}}],f={id:64,slug:n,titleEn:o,difficulty:"中等",category:t,officialTags:c,paidOnly:!1,sourceUrl:i,title:s,studyTags:l,summary:r,insight:u,pitfalls:m,solutions:e};export{t as category,f as default,a as difficulty,d as id,u as insight,c as officialTags,g as paidOnly,m as pitfalls,n as slug,e as solutions,i as sourceUrl,l as studyTags,r as summary,s as title,o as titleEn};
