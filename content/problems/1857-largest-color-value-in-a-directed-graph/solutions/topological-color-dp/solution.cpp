class Solution {
    public: int largestPathValue(string colors,vector<vector<int>>& edges){
        int n=colors.size();
        vector<vector<int>> graph(n);
        vector<int> indegree(n);
        for(auto& edge:edges){
            graph[edge[0]].push_back(edge[1]);
            ++indegree[edge[1]];
        }
        vector<array<int,26>> dp(n);
        queue<int> pending;
        for(int i=0;i<n;++i)if(!indegree[i]){
            dp[i][colors[i]-'a']=1;
            pending.push(i);
        }
        int processed=0,answer=0;
        while(!pending.empty()){
            int node=pending.front();
            pending.pop();
            ++processed;
            answer=max(answer,*max_element(dp[node].begin(),dp[node].end()));
            for(int next:graph[node]){
                int own=colors[next]-'a';
                for(int color=0;color<26;++color)dp[next][color]=max(dp[next][color],dp[node][color]+(color==own));
                if(!--indegree[next])pending.push(next);
            }
        }
        return processed==n?answer:-1;
    }
};
