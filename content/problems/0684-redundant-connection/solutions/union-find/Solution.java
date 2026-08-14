class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1]; for (int node = 1; node < parent.length; node++) parent[node] = node;
        for (int[] edge : edges) { int first = find(parent, edge[0]), second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second; }
        return new int[0];
    }
    private int find(int[] parent, int node) { if (parent[node] != node) parent[node] = find(parent, parent[node]); return parent[node]; }
}
