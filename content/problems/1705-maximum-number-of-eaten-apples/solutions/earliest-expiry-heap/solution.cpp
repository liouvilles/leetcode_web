class Solution {
    public: int eatenApples(vector<int>& apples,vector<int>& days){
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> batches;
        int eaten=0;
        for(int day=0;day<(int)apples.size()||!batches.empty();++day){
            if(day<(int)apples.size()&&apples[day])batches.push({
                day+days[day],apples[day]
            });
            while(!batches.empty()&&batches.top().first<=day)batches.pop();
            if(!batches.empty()){
                auto [expiry,count]=batches.top();
                batches.pop();
                ++eaten;
                if(--count)batches.push({
                    expiry,count
                });
            }
        }
        return eaten;
    }
};
