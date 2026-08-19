class Solution {
    int best;
    vector<int> jobs,loads;
    void dfs(int index){
        if(index==(int)jobs.size()){
            best=min(best,*max_element(loads.begin(),loads.end()));
            return;
        }
        unordered_set<int> seen;
        for(int& load:loads){
            if(!seen.insert(load).second||load+jobs[index]>=best)continue;
            load+=jobs[index];
            dfs(index+1);
            load-=jobs[index];
            if(!load)break;
        }
    }
    public:int minimumTimeRequired(vector<int>& input,int k){
        jobs=input;
        sort(jobs.rbegin(),jobs.rend());
        loads.assign(k,0);
        best=accumulate(jobs.begin(),jobs.end(),0);
        dfs(0);
        return best;
    }
};
