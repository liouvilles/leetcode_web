class Solution {
    public: int checkWays(vector<vector<int>>& pairs){
        unordered_map<int,unordered_set<int>> graph;
        for(auto& pair:pairs){
            graph[pair[0]].insert(pair[1]);
            graph[pair[1]].insert(pair[0]);
        }
        int root=-1;
        for(auto& [node,neighbors]:graph)if(neighbors.size()==graph.size()-1){
            root=node;
            break;
        }
        if(root<0)return 0;
        int answer=1;
        for(auto& [node,neighbors]:graph){
            if(node==root)continue;
            int degree=neighbors.size(),parent=-1,parentDegree=INT_MAX;
            for(int neighbor:neighbors){
                int candidateDegree=graph[neighbor].size();
                if(candidateDegree>=degree&&candidateDegree<parentDegree){
                    parent=neighbor;
                    parentDegree=candidateDegree;
                }
            }
            if(parent<0)return 0;
            for(int neighbor:neighbors)if(neighbor!=parent&&!graph[parent].count(neighbor))return 0;
            if(parentDegree==degree)answer=2;
        }
        return answer;
    }
};
