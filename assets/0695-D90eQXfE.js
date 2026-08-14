const d=695,r="max-area-of-island",n="Max Area of Island",u="中等",m="图论",o=["数组","深度优先搜索","广度优先搜索","并查集","矩阵"],g=!1,i="https://leetcode.cn/problems/max-area-of-island/",t="岛屿的最大面积",a=["网格 DFS","连通分量","原地标记"],e="在只含零和一的网格中，求上下左右相连的一组成陆地格子的最大数量。",c="每遇到未访问陆地就启动一次 DFS，递归淹没整个连通分量并累计面积。",l=["只按四个方向连接","访问时立即置零防止重复计数","没有陆地时答案为零"],s=[{id:"flood-fill-dfs",title:"原地淹没 DFS",kind:"最优",idea:"把访问过的陆地改为零，同时返回当前连通分量面积。",steps:["遍历所有格子寻找陆地","DFS 越界或遇水返回零","当前格置零并返回一加四邻面积"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int best = 0; for (int row = 0; row < grid.length; row++) for (int column = 0; column < grid[0].length; column++) best = Math.max(best, area(grid, row, column)); return best;
    }
    private int area(int[][] grid, int row, int column) { if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1); }
}
`,kotlin:`class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int { var best = 0; for (row in grid.indices) for (column in grid[0].indices) best = maxOf(best, area(grid, row, column)); return best }
    private fun area(grid: Array<IntArray>, row: Int, column: Int): Int { if (row !in grid.indices || column !in grid[0].indices || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1) }
}
`,cpp:`class Solution {
    int area(vector<vector<int>>& grid, int row, int column) { if (row < 0 || row >= (int)grid.size() || column < 0 || column >= (int)grid[0].size() || grid[row][column] == 0) return 0; grid[row][column] = 0; return 1 + area(grid, row + 1, column) + area(grid, row - 1, column) + area(grid, row, column + 1) + area(grid, row, column - 1); }
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) { int best = 0; for (int row = 0; row < (int)grid.size(); ++row) for (int column = 0; column < (int)grid[0].size(); ++column) best = max(best, area(grid, row, column)); return best; }
};
`}}],w={id:695,slug:r,titleEn:n,difficulty:"中等",category:"图论",officialTags:o,paidOnly:!1,sourceUrl:i,title:t,studyTags:a,summary:e,insight:c,pitfalls:l,solutions:s};export{m as category,w as default,u as difficulty,d as id,c as insight,o as officialTags,g as paidOnly,l as pitfalls,r as slug,s as solutions,i as sourceUrl,a as studyTags,e as summary,t as title,n as titleEn};
