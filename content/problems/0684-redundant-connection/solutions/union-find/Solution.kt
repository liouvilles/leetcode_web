class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) { it }
        for (edge in edges) { val first = find(parent, edge[0]); val second = find(parent, edge[1]); if (first == second) return edge; parent[first] = second }
        return intArrayOf()
    }
    private fun find(parent: IntArray, node: Int): Int { if (parent[node] != node) parent[node] = find(parent, parent[node]); return parent[node] }
}
