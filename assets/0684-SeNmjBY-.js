const p=684,n="redundant-connection",e="Redundant Connection",f="中等",l="图论",t=["深度优先搜索","广度优先搜索","并查集","图论"],u=!1,d="https://leetcode.cn/problems/redundant-connection/",i="冗余连接",r=["并查集","环检测","无向图"],o="一棵 n 节点树额外加入一条边后，找出可以删除使图重新成为树的那条边。",a="按输入顺序加入边，若两个端点已经属于同一连通分量，当前边就是形成环的冗余边。",s=["节点编号从一开始","需要按输入顺序处理边","路径压缩可降低查找开销"],c=[{id:"union-find",title:"并查集判环",kind:"最优",idea:"每条边尝试合并两个集合，合并失败时返回当前边。",steps:["初始化每个节点父亲为自身","find 使用路径压缩","根相同则当前边冗余，否则连接两个根"],complexity:{time:"O(n α(n))",space:"O(n)"},code:{java:`class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1]; for (int node = 1; node < parent.length; node++) parent[node] = node;
        for (int[] edge : edges) { int first = find(parent, edge[0]), second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second; }
        return new int[0];
    }
    private int find(int[] parent, int node) { if (parent[node] != node) parent[node] = find(parent, parent[node]); return parent[node]; }
}
`,kotlin:`class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) { it }
        for (edge in edges) { val first = find(parent, edge[0]); val second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second }
        return intArrayOf()
    }
    private fun find(parent: IntArray, node: Int): Int { if (parent[node] != node) parent[node] = find(parent, parent[node]); return parent[node] }
}
`,cpp:`class Solution {
    int find(vector<int>& parent, int node) { return parent[node] == node ? node : parent[node] = find(parent, parent[node]); }
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<int> parent(edges.size() + 1); iota(parent.begin(), parent.end(), 0);
        for (auto& edge : edges) { int first = find(parent, edge[0]), second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second; }
        return {};
    }
};
`}}],g={id:684,slug:n,titleEn:e,difficulty:"中等",category:"图论",officialTags:t,paidOnly:!1,sourceUrl:d,title:i,studyTags:r,summary:o,insight:a,pitfalls:s,solutions:c};export{l as category,g as default,f as difficulty,p as id,a as insight,t as officialTags,u as paidOnly,s as pitfalls,n as slug,c as solutions,d as sourceUrl,r as studyTags,o as summary,i as title,e as titleEn};
