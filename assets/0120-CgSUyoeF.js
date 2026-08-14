const a=120,n="triangle",o="Triangle",d="中等",t="动态规划",i=["数组","动态规划"],p=!1,l="https://leetcode.cn/problems/triangle/",c="三角形最小路径和",r=["动态规划","自底向上","滚动数组"],e="从三角形顶点走到最后一行，每步只能走到下一行同列或后一列，求路径元素的最小总和。",s="从底向上计算时，位置 (row,column) 的最优后缀只依赖下一行 dp[column] 与 dp[column+1]。",u=["相邻位置仅有正下方和右下方","元素可能为负","一维数组应从底部向上覆盖"],m=[{id:"bottom-up-dp",title:"自底向上一维动态规划",kind:"最优",idea:"把下一行的最小后缀合并到当前行，最终 dp[0] 即答案。",steps:["dp 初始化为零或末行","从最后一行向顶行遍历","dp[column]=value+min(dp[column],dp[column+1])"],complexity:{time:"O(n²)",space:"O(n)"},code:{java:`class Solution {
    public int minimumTotal(List<List<Integer>> triangle) { int[] dp = new int[triangle.size() + 1]; for (int row = triangle.size() - 1; row >= 0; row--) for (int column = 0; column <= row; column++) dp[column] = triangle.get(row).get(column) + Math.min(dp[column], dp[column + 1]); return dp[0]; }
}
`,kotlin:`class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int { val dp = IntArray(triangle.size + 1); for (row in triangle.lastIndex downTo 0) for (column in 0..row) dp[column] = triangle[row][column] + minOf(dp[column], dp[column + 1]); return dp[0] }
}
`,cpp:`class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) { vector<int> dp(triangle.size() + 1); for (int row = triangle.size() - 1; row >= 0; --row) for (int column = 0; column <= row; ++column) dp[column] = triangle[row][column] + min(dp[column], dp[column + 1]); return dp[0]; }
};
`}}],g={id:120,slug:n,titleEn:o,difficulty:"中等",category:t,officialTags:i,paidOnly:!1,sourceUrl:l,title:c,studyTags:r,summary:e,insight:s,pitfalls:u,solutions:m};export{t as category,g as default,d as difficulty,a as id,s as insight,i as officialTags,p as paidOnly,u as pitfalls,n as slug,m as solutions,l as sourceUrl,r as studyTags,e as summary,c as title,o as titleEn};
