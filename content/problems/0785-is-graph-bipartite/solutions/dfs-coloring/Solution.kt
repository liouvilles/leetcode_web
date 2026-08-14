class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val colors = IntArray(graph.size)
        for (node in graph.indices) if (colors[node] == 0 && !paint(graph, colors, node, 1)) return false
        return true
    }
    private fun paint(graph: Array<IntArray>, colors: IntArray, node: Int, color: Int): Boolean { colors[node] = color; for (next in graph[node]) { if (colors[next] == color) return false; if (colors[next] == 0 && !paint(graph, colors, next, -color)) return false }; return true }
}
