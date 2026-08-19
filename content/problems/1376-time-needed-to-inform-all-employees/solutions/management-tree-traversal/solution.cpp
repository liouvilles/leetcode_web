class Solution {
    public: int numOfMinutes(int n,int headID,vector<int>& manager,vector<int>& informTime){
        vector<vector<int>> children(n);
        for(int employee=0;employee<n;++employee)if(manager[employee]!=-1)children[manager[employee]].push_back(employee);
        stack<pair<int,int>> pending;
        pending.push({
            headID,0
        });
        int answer=0;
        while(!pending.empty()){
            auto [node,time]=pending.top();
            pending.pop();
            answer=max(answer,time);
            for(int child:children[node])pending.push({
                child,time+informTime[node]
            });
        }
        return answer;
    }
};
