class Solution {
    vector<int> topological(vector<vector<int>>& graph,vector<int> degree){
        queue<int> pending;
        for(int i=0;i<(int)degree.size();++i)if(!degree[i])pending.push(i);
        vector<int> order;
        while(!pending.empty()){
            int node=pending.front();
            pending.pop();
            order.push_back(node);
            for(int next:graph[node])if(!--degree[next])pending.push(next);
        }
        return order;
    }
    public:vector<int> sortItems(int n,int m,vector<int>& group,vector<vector<int>>& beforeItems){
        int groupCount=m;
        for(int& value:group)if(value==-1)value=groupCount++;
        vector<vector<int>> itemGraph(n),groupGraph(groupCount);
        vector<int> itemDegree(n),groupDegree(groupCount);
        unordered_set<long long> groupEdges;
        for(int item=0;item<n;++item)for(int previous:beforeItems[item]){
            itemGraph[previous].push_back(item);
            ++itemDegree[item];
            if(group[previous]!=group[item]){
                long long key=(long long)group[previous]*groupCount+group[item];
                if(groupEdges.insert(key).second){
                    groupGraph[group[previous]].push_back(group[item]);
                    ++groupDegree[group[item]];
                }
            }
        }
        auto itemOrder=topological(itemGraph,itemDegree),groupOrder=topological(groupGraph,groupDegree);
        if((int)itemOrder.size()!=n||(int)groupOrder.size()!=groupCount)return {
        };
        vector<vector<int>> byGroup(groupCount);
        for(int item:itemOrder)byGroup[group[item]].push_back(item);
        vector<int> answer;
        for(int value:groupOrder)answer.insert(answer.end(),byGroup[value].begin(),byGroup[value].end());
        return answer;
    }
};
