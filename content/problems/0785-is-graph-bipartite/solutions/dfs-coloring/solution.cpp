class Solution {
    bool paint(const vector<vector<int>>& graph, vector<int>& colors, int node, int color) { colors[node] = color; for (int next : graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false; } return true; }
public:
    bool isBipartite(vector<vector<int>>& graph) { vector<int> colors(graph.size()); for (int node = 0; node < (int)graph.size(); ++node) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false; return true; }
};
