const d=207,e="course-schedule",n="Course Schedule",a="中等",l="图论",r=["深度优先搜索","广度优先搜索","图论","拓扑排序","Directed Acyclic Graph"],p=!1,s="https://leetcode.cn/problems/course-schedule/",g="课程表",t=["拓扑排序","入度","环检测"],o="课程之间存在先修关系，判断能否完成全部课程；若依赖关系形成有向环则无法完成。",u="不断移除入度为零的课程；若最终所有课程都被移除，依赖图就是无环图。",i=["关系 [a,b] 表示 b 指向 a","同一课程可能解锁多个后续课程","最终判断应比较已处理课程数而不是队列是否曾经非空"],c=[{id:"kahn-topological-sort",title:"Kahn 拓扑排序",kind:"最优",idea:"建立邻接表和入度数组，从所有零入度课程开始逐层删除依赖边。",steps:["统计每门课程入度并建立后继列表","把所有零入度课程加入队列","弹出课程、减少后继入度并统计已完成数量"],complexity:{time:"O(V + E)",space:"O(V + E)"},code:{java:`class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) if (indegree[course] == 0) queue.offer(course);
        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;
            for (int next : graph.get(course)) if (--indegree[next] == 0) queue.offer(next);
        }
        return completed == numCourses;
    }
}
`,kotlin:`class Solution {
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
`,cpp:`class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses);
        vector<int> indegree(numCourses);
        for (const auto& edge : prerequisites) {
            graph[edge[1]].push_back(edge[0]);
            ++indegree[edge[0]];
        }
        queue<int> pending;
        for (int course = 0; course < numCourses; ++course) if (indegree[course] == 0) pending.push(course);
        int completed = 0;
        while (!pending.empty()) {
            int course = pending.front(); pending.pop();
            ++completed;
            for (int next : graph[course]) if (--indegree[next] == 0) pending.push(next);
        }
        return completed == numCourses;
    }
};
`}}],m={id:207,slug:e,titleEn:n,difficulty:"中等",category:"图论",officialTags:r,paidOnly:!1,sourceUrl:s,title:"课程表",studyTags:t,summary:o,insight:u,pitfalls:i,solutions:c};export{l as category,m as default,a as difficulty,d as id,u as insight,r as officialTags,p as paidOnly,i as pitfalls,e as slug,c as solutions,s as sourceUrl,t as studyTags,o as summary,g as title,n as titleEn};
