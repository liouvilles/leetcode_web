class Solution {
    public: int minimumTime(int n,vector<vector<int>>& relations,vector<int>& time){
        vector<vector<int>> graph(n);
        vector<int> indegree(n),finish=time;
        for(auto& relation:relations){
            graph[relation[0]-1].push_back(relation[1]-1);
            ++indegree[relation[1]-1];
        }
        queue<int> pending;
        for(int i=0;i<n;++i)if(!indegree[i])pending.push(i);
        while(!pending.empty()){
            int course=pending.front();
            pending.pop();
            for(int next:graph[course]){
                finish[next]=max(finish[next],finish[course]+time[next]);
                if(!--indegree[next])pending.push(next);
            }
        }
        return *max_element(finish.begin(),finish.end());
    }
};
