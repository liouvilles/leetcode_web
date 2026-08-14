class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = List(numCourses) { ArrayList<Int>() }
        val indegree = IntArray(numCourses)
        for (edge in prerequisites) {
            graph[edge[1]].add(edge[0])
            indegree[edge[0]]++
        }
        val queue: ArrayDeque<Int> = ArrayDeque()
        for (course in 0 until numCourses) if (indegree[course] == 0) queue.add(course)
        var completed = 0
        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            completed++
            for (next in graph[course]) {
                indegree[next]--
                if (indegree[next] == 0) queue.add(next)
            }
        }
        return completed == numCourses
    }
}
