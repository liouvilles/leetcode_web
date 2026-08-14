class Solution {
    int find(vector<int>& parent, int node) { return parent[node] == node ? node : parent[node] = find(parent, parent[node]); }
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<int> parent(edges.size() + 1); iota(parent.begin(), parent.end(), 0);
        for (auto& edge : edges) { int first = find(parent, edge[0]), second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second; }
        return {};
    }
};
