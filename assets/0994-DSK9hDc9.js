const f=994,n="rotting-oranges",i="Rotting Oranges",g="中等",r="搜索与回溯",e=["数组","广度优先搜索","矩阵"],m=!1,o="https://leetcode.cn/problems/rotting-oranges/",t="腐烂的橘子",s=["多源 BFS","按层计时","网格传播"],u="网格中腐烂橘子每分钟使上下左右相邻的新鲜橘子腐烂，求所有新鲜橘子腐烂的最短时间；无法完成则返回 -1。",c="所有初始腐烂橘子同时作为 BFS 源点，每扩展一层就代表经过一分钟。",l=["初始没有新鲜橘子时答案为零","同一新鲜橘子入队时就应标记腐烂","BFS 后仍有新鲜橘子则失败"],d=[{id:"multi-source-bfs",title:"多源分层 BFS",kind:"最优",idea:"初始腐烂位置全部入队，按层感染相邻新鲜位置。",steps:["统计新鲜橘子并收集所有源点","每层处理当前队列长度并感染邻居","新鲜数归零时返回分钟数，否则返回 -1"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>(); int fresh = 0;
        for (int row = 0; row < grid.length; row++) for (int column = 0; column < grid[0].length; column++) { if (grid[row][column] == 2) queue.offer(new int[] {row, column}); else if (grid[row][column] == 1) fresh++; }
        int minutes = 0; int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (fresh > 0 && !queue.isEmpty()) { int size = queue.size(); minutes++; while (size-- > 0) { int[] cell = queue.poll(); for (int[] direction : directions) { int row = cell[0] + direction[0], column = cell[1] + direction[1]; if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1) { grid[row][column] = 2; fresh--; queue.offer(new int[] {row, column}); } } } }
        return fresh == 0 ? minutes : -1;
    }
}
`,kotlin:`class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue: ArrayDeque<IntArray> = ArrayDeque(); var fresh = 0
        for (row in grid.indices) for (column in grid[0].indices) if (grid[row][column] == 2) queue.add(intArrayOf(row, column)) else if (grid[row][column] == 1) fresh++
        val directions = arrayOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0,-1)); var minutes = 0
        while (fresh > 0 && queue.isNotEmpty()) { repeat(queue.size) { val cell = queue.removeFirst(); for (direction in directions) { val row = cell[0] + direction[0]; val column = cell[1] + direction[1]; if (row in grid.indices && column in grid[0].indices && grid[row][column] == 1) { grid[row][column] = 2; fresh--; queue.add(intArrayOf(row, column)) } } }; minutes++ }
        return if (fresh == 0) minutes else -1
    }
}
`,cpp:`class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> pending; int fresh = 0;
        for (int row = 0; row < (int)grid.size(); ++row) for (int column = 0; column < (int)grid[0].size(); ++column) { if (grid[row][column] == 2) pending.push({row,column}); else if (grid[row][column] == 1) ++fresh; }
        int minutes = 0; int directions[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
        while (fresh > 0 && !pending.empty()) { int size = pending.size(); ++minutes; while (size--) { auto [r,c] = pending.front(); pending.pop(); for (auto& direction : directions) { int row = r + direction[0], column = c + direction[1]; if (row >= 0 && row < (int)grid.size() && column >= 0 && column < (int)grid[0].size() && grid[row][column] == 1) { grid[row][column] = 2; --fresh; pending.push({row,column}); } } } }
        return fresh == 0 ? minutes : -1;
    }
};
`}}],a={id:994,slug:n,titleEn:i,difficulty:"中等",category:r,officialTags:e,paidOnly:!1,sourceUrl:o,title:t,studyTags:s,summary:u,insight:c,pitfalls:l,solutions:d};export{r as category,a as default,g as difficulty,f as id,c as insight,e as officialTags,m as paidOnly,l as pitfalls,n as slug,d as solutions,o as sourceUrl,s as studyTags,u as summary,t as title,i as titleEn};
