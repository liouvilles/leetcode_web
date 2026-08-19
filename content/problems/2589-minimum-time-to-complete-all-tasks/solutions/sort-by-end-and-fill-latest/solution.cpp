class Solution {
    public:int findMinimumTime(vector<vector<int>>& tasks){
        sort(tasks.begin(),tasks.end(),[](auto& a,auto& b){
            return a[1]<b[1];
        });
        int maximum=0;
        for(auto& task:tasks)maximum=max(maximum,task[1]);
        vector<bool> selected(maximum+1);
        int answer=0;
        for(auto& task:tasks){
            int need=task[2];
            for(int time=task[0];time<=task[1];++time)need-=selected[time];
            for(int time=task[1];need>0;--time)if(!selected[time]){
                selected[time]=true;
                ++answer;
                --need;
            }
        }
        return answer;
    }
};
