const p=785,o="is-graph-bipartite",n="Is Graph Bipartite?",d="中等",f="图论",r=["深度优先搜索","广度优先搜索","并查集","图论","Graph Coloring","二分图"],u=!1,t="https://leetcode.cn/problems/is-graph-bipartite/",e="判断二分图",i=["图染色","深度优先搜索","连通分量"],l="给定无向图邻接表，判断能否把节点分成两组，使每条边的两个端点属于不同组。",s="对每个连通分量执行二染色，相邻节点必须使用相反颜色；出现颜色冲突就不是二分图。",a=["图可能不连通","颜色零表示未访问","已经染色的邻居需要检查颜色而不是跳过所有逻辑"],c=[{id:"dfs-coloring",title:"DFS 二染色",kind:"最优",idea:"从每个未染色节点开始递归，用正负一代表两种颜色。",steps:["遍历全部节点覆盖每个分量","未染色邻居赋相反颜色","已染色邻居同色时失败"],complexity:{time:"O(V+E)",space:"O(V)"},code:{java:`class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int node = 0; node < graph.length; node++) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false;
        return true;
    }
    private boolean paint(int[][] graph, int[] colors, int node, int color) { colors[node] = color; for (int next : graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false; } return true; }
}
`,kotlin:`class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val colors = IntArray(graph.size)
        for (node in graph.indices) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false
        return true
    }
    private fun paint(graph: Array<IntArray>, colors: IntArray, node: Int, color: Int): Boolean { colors[node] = color; for (next in graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false }; return true }
}
`,cpp:`class Solution {
    bool paint(const vector<vector<int>>& graph, vector<int>& colors, int node, int color) { colors[node] = color; for (int next : graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false; } return true; }
public:
    bool isBipartite(vector<vector<int>>& graph) { vector<int> colors(graph.size()); for (int node = 0; node < (int)graph.size(); ++node) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false; return true; }
};
`}}],g={id:785,slug:o,titleEn:n,difficulty:"中等",category:"图论",officialTags:r,paidOnly:!1,sourceUrl:t,title:e,studyTags:i,summary:l,insight:s,pitfalls:a,solutions:c};export{f as category,g as default,d as difficulty,p as id,s as insight,r as officialTags,u as paidOnly,a as pitfalls,o as slug,c as solutions,t as sourceUrl,i as studyTags,l as summary,e as title,n as titleEn};
