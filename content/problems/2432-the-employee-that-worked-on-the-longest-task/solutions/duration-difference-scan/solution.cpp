class Solution {
    public:int hardestWorker(int n,vector<vector<int>>& logs){
        int previous=0,best=-1,answer=n;
        for(auto& log:logs){
            int duration=log[1]-previous;
            if(duration>best||(duration==best&&log[0]<answer)){
                best=duration;
                answer=log[0];
            }
            previous=log[1];
        }
        return answer;
    }
};
