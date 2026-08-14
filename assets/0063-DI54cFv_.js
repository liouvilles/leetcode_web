const a=63,n="unique-paths-ii",o="Unique Paths II",p="中等",t="动态规划",i=["数组","动态规划","矩阵"],m=!1,c="https://leetcode.cn/problems/unique-paths-ii/",l="不同路径 II",s=["动态规划","网格路径","滚动数组"],e="在含障碍物的网格中，只能向右或向下移动，计算从左上角到右下角的不同路径数量。",u="一维数组 dp[column] 在更新前表示来自上方的路径数，更新后的 dp[column-1] 表示来自左侧；障碍处清零。",d=["起点或终点可能是障碍","遇到障碍必须把已有 dp 值清零","第一行和第一列无需单独分支"],r=[{id:"one-dimensional-dp",title:"一维滚动动态规划",kind:"最优",idea:"逐行更新到达每个格子的路径数，障碍格不可继承路径。",steps:["dp[0] 按起点是否可用初始化","障碍格令 dp[column]=0","普通格累加左侧 dp[column-1]"],complexity:{time:"O(mn)",space:"O(n)"},code:{java:`class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length]; dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] row : obstacleGrid) for (int column = 0; column < row.length; column++) { if (row[column] == 1) dp[column] = 0; else if (column > 0) dp[column] += dp[column - 1]; }
        return dp[dp.length - 1];
    }
}
`,kotlin:`class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = IntArray(obstacleGrid[0].size); dp[0] = if (obstacleGrid[0][0] == 0) 1 else 0
        for (row in obstacleGrid) for (column in row.indices) { if (row[column] == 1) dp[column] = 0 else if (column > 0) dp[column] += dp[column - 1] }
        return dp.last()
    }
}
`,cpp:`class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<int> dp(obstacleGrid[0].size()); dp[0] = obstacleGrid[0][0] == 0;
        for (const auto& row : obstacleGrid) for (int column = 0; column < (int)row.size(); ++column) { if (row[column] == 1) dp[column] = 0; else if (column > 0) dp[column] += dp[column - 1]; }
        return dp.back();
    }
};
`}}],f={id:63,slug:n,titleEn:o,difficulty:"中等",category:t,officialTags:i,paidOnly:!1,sourceUrl:c,title:l,studyTags:s,summary:e,insight:u,pitfalls:d,solutions:r};export{t as category,f as default,p as difficulty,a as id,u as insight,i as officialTags,m as paidOnly,d as pitfalls,n as slug,r as solutions,c as sourceUrl,s as studyTags,e as summary,l as title,o as titleEn};
