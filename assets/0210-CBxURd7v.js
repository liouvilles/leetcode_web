const a=210,e="course-schedule-ii",n="Course Schedule II",g="中等",p="图论",r=["深度优先搜索","广度优先搜索","图论","拓扑排序"],l=!1,s="https://leetcode.cn/problems/course-schedule-ii/",t="课程表 II",u=["拓扑排序","入度","课程顺序"],i="根据课程先修关系返回一个可以完成全部课程的学习顺序；若依赖图有环则返回空数组。",o="依次选择入度为零的课程并删除它的出边，得到的处理顺序就是一种拓扑序。",c=["关系 [a,b] 表示 b 是 a 的先修课","可能存在多个合法顺序","处理数量不足 numCourses 时必须返回空数组"],d=[{id:"kahn-order",title:"Kahn 拓扑序",kind:"最优",idea:"零入度队列逐步释放后继课程，同时写入结果数组。",steps:["建立邻接表与入度","所有零入度课程入队","弹出并减少后继入度，最后检查处理数量"],complexity:{time:"O(V+E)",space:"O(V+E)"},code:{java:`class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses]; for (int[] edge : prerequisites) { graph.get(edge[1]).add(edge[0]); indegree[edge[0]]++; }
        Queue<Integer> queue = new ArrayDeque<>(); for (int course = 0; course < numCourses; course++) if (indegree[course] == 0) queue.offer(course);
        int[] order = new int[numCourses]; int count = 0;
        while (!queue.isEmpty()) { int course = queue.poll(); order[count++] = course; for (int next : graph.get(course)) if (--indegree[next] == 0) queue.offer(next); }
        return count == numCourses ? order : new int[0];
    }
}
`,kotlin:`class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = List(numCourses) { ArrayList<Int>() }; val indegree = IntArray(numCourses)
        for (edge in prerequisites) { graph[edge[1]].add(edge[0]); indegree[edge[0]]++ }
        val queue: ArrayDeque<Int> = ArrayDeque(); for (course in 0 until numCourses) if (indegree[course] == 0) queue.add(course)
        val order = IntArray(numCourses); var count = 0
        while (queue.isNotEmpty()) { val course = queue.removeFirst(); order[count++] = course; for (next in graph[course]) { indegree[next]--; if (indegree[next] == 0) queue.add(next) } }
        return if (count == numCourses) order else intArrayOf()
    }
}
`,cpp:`class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses); vector<int> indegree(numCourses);
        for (const auto& edge : prerequisites) { graph[edge[1]].push_back(edge[0]); ++indegree[edge[0]]; }
        queue<int> pending; for (int course = 0; course < numCourses; ++course) if (indegree[course] == 0) pending.push(course);
        vector<int> order; while (!pending.empty()) { int course = pending.front(); pending.pop(); order.push_back(course); for (int next : graph[course]) if (--indegree[next] == 0) pending.push(next); }
        return order.size() == (size_t)numCourses ? order : vector<int>{};
    }
};
`}}],f={id:210,slug:e,titleEn:n,difficulty:"中等",category:"图论",officialTags:r,paidOnly:!1,sourceUrl:s,title:t,studyTags:u,summary:i,insight:o,pitfalls:c,solutions:d};export{p as category,f as default,g as difficulty,a as id,o as insight,r as officialTags,l as paidOnly,c as pitfalls,e as slug,d as solutions,s as sourceUrl,u as studyTags,i as summary,t as title,n as titleEn};
