class Solution {
    public: int maxProfitAssignment(vector<int>& difficulty,vector<int>& profit,vector<int>& worker){
        vector<pair<int,int>> jobs;
        for(int i=0;i<(int)difficulty.size();++i)jobs.push_back({
            difficulty[i],profit[i]
        });
        sort(jobs.begin(),jobs.end());
        sort(worker.begin(),worker.end());
        int answer=0,best=0,index=0;
        for(int ability:worker){
            while(index<(int)jobs.size()&&jobs[index].first<=ability){
                best=max(best,jobs[index].second);
                ++index;
            }
            answer+=best;
        }
        return answer;
    }
};
