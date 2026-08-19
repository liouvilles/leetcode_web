class Solution {
    public:int findCrossingTime(int n,int k,vector<vector<int>>& time){
        priority_queue<pair<int,int>> waitLeft,waitRight;
        using Event=pair<long long,int>;
        priority_queue<Event,vector<Event>,greater<Event>> workLeft,workRight;
        for(int worker=0;worker<k;++worker)waitLeft.push({
            time[worker][0]+time[worker][2],worker
        });
        long long current=0;
        int boxes=n;
        while(boxes>0||!waitRight.empty()||!workRight.empty()){
            while(!workLeft.empty()&&workLeft.top().first<=current){
                int worker=workLeft.top().second;
                workLeft.pop();
                waitLeft.push({
                    time[worker][0]+time[worker][2],worker
                });
            }while(!workRight.empty()&&workRight.top().first<=current){
                int worker=workRight.top().second;
                workRight.pop();
                waitRight.push({
                    time[worker][0]+time[worker][2],worker
                });
            }
            if(!waitRight.empty()){
                int worker=waitRight.top().second;
                waitRight.pop();
                current+=time[worker][2];
                workLeft.push({
                    current+time[worker][3],worker
                });
            }else if(boxes>0&&!waitLeft.empty()){
                int worker=waitLeft.top().second;
                waitLeft.pop();
                current+=time[worker][0];
                --boxes;
                workRight.push({
                    current+time[worker][1],worker
                });
            }else{
                long long next=LLONG_MAX;
                if(!workLeft.empty())next=min(next,workLeft.top().first);
                if(!workRight.empty())next=min(next,workRight.top().first);
                current=max(current,next);
            }
        }
        return current;
    }
};
