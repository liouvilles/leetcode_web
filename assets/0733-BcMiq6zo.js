const m=733,i="flood-fill",n="Flood Fill",f="简单",o="搜索与回溯",l=["数组","深度优先搜索","广度优先搜索","矩阵"],u=!1,r="https://leetcode.cn/problems/flood-fill/",e="图像渲染",c=["网格搜索","连通区域","原地标记"],t="从指定像素出发，把所有与起点颜色相同且上下左右连通的像素改成新颜色。",a="这是以起点为源、以颜色相等为通行条件的连通块搜索。",s=["原颜色等于新颜色时必须提前返回","只允许四方向连接","入队或递归前及时改色可充当 visited"],g=[{id:"recursive-dfs",title:"递归 DFS",kind:"最优",idea:"把当前像素改色后，递归处理仍为原颜色的四个邻居。",steps:["保存起点原颜色并处理同色特例","越界或颜色不同则返回","改色并递归四邻域"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) fill(image, sr, sc, original, color);
        return image;
    }

    private void fill(int[][] image, int row, int col, int original, int color) {
        if (row < 0 || row == image.length || col < 0 || col == image[0].length
                || image[row][col] != original) return;
        image[row][col] = color;
        fill(image, row + 1, col, original, color); fill(image, row - 1, col, original, color);
        fill(image, row, col + 1, original, color); fill(image, row, col - 1, original, color);
    }
}
`,kotlin:`class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val original = image[sr][sc]
        if (original == color) return image
        fun fill(row: Int, col: Int) {
            if (row !in image.indices || col !in image[0].indices || image[row][col] != original) return
            image[row][col] = color
            fill(row + 1, col); fill(row - 1, col)
            fill(row, col + 1); fill(row, col - 1)
        }
        fill(sr, sc)
        return image
    }
}
`,cpp:`class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) fill(image, sr, sc, original, color);
        return image;
    }

private:
    void fill(vector<vector<int>>& image, int row, int col, int original, int color) {
        if (row < 0 || row == (int)image.size() || col < 0 || col == (int)image[0].size()
                || image[row][col] != original) return;
        image[row][col] = color;
        fill(image, row + 1, col, original, color); fill(image, row - 1, col, original, color);
        fill(image, row, col + 1, original, color); fill(image, row, col - 1, original, color);
    }
};
`}},{id:"iterative-bfs",title:"队列 BFS",kind:"进阶",idea:"起点入队并改色，随后不断扩展仍为原颜色的相邻像素。",steps:["处理原色与新色相同的特例","起点改色后入队","弹出位置并检查四邻域，命中原色就改色入队"],complexity:{time:"O(mn)",space:"O(mn)"},code:{java:`class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        int[] directions = {1, 0, -1, 0, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int d = 0; d < 4; d++) {
                int row = cell[0] + directions[d], col = cell[1] + directions[d + 1];
                if (row >= 0 && row < image.length && col >= 0 && col < image[0].length
                        && image[row][col] == original) {
                    image[row][col] = color;
                    queue.offer(new int[] {row, col});
                }
            }
        }
        return image;
    }
}
`,kotlin:`class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val original = image[sr][sc]
        if (original == color) return image
        val directions = intArrayOf(1, 0, -1, 0, 1)
        val queue = java.util.ArrayDeque<IntArray>()
        queue.offer(intArrayOf(sr, sc))
        image[sr][sc] = color
        while (queue.isNotEmpty()) {
            val cell = queue.poll()
            for (d in 0 until 4) {
                val row = cell[0] + directions[d]
                val col = cell[1] + directions[d + 1]
                if (row in image.indices && col in image[0].indices && image[row][col] == original) {
                    image[row][col] = color
                    queue.offer(intArrayOf(row, col))
                }
            }
        }
        return image
    }
}
`,cpp:`class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        const int directions[5] = {1, 0, -1, 0, 1};
        queue<pair<int, int>> cells;
        cells.push({sr, sc});
        image[sr][sc] = color;
        while (!cells.empty()) {
            auto [r, c] = cells.front(); cells.pop();
            for (int d = 0; d < 4; ++d) {
                int row = r + directions[d], col = c + directions[d + 1];
                if (row >= 0 && row < (int)image.size() && col >= 0 && col < (int)image[0].size()
                        && image[row][col] == original) {
                    image[row][col] = color;
                    cells.push({row, col});
                }
            }
        }
        return image;
    }
};
`}}],d={id:733,slug:i,titleEn:n,difficulty:"简单",category:o,officialTags:l,paidOnly:!1,sourceUrl:r,title:e,studyTags:c,summary:t,insight:a,pitfalls:s,solutions:g};export{o as category,d as default,f as difficulty,m as id,a as insight,l as officialTags,u as paidOnly,s as pitfalls,i as slug,g as solutions,r as sourceUrl,c as studyTags,t as summary,e as title,n as titleEn};
