class Solution {
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
