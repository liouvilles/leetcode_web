class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = List(numCourses) { ArrayList<Int>() }; val indegree = IntArray(numCourses)
        for (edge in prerequisites) { graph[edge[1]].add(edge[0]); indegree[edge[0]]++ }
        val queue: ArrayDeque<Int> = ArrayDeque(); for (course in 0 until numCourses) if (indegree[course] == 0) queue.add(course)
        val order = IntArray(numCourses); var count = 0
        while (queue.isNotEmpty()) { val course = queue.removeFirst(); order[count++] = course; for (next in graph[course]) { indegree[next]--; if (indegree[next] == 0) queue.add(next) } }
        return if (count == numCourses) order else intArrayOf()
    }
}
