class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int node = 0; node < graph.length; node++) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false;
        return true;
    }
    private boolean paint(int[][] graph, int[] colors, int node, int color) { colors[node] = color; for (int next : graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false; } return true; }
}
