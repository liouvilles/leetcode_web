class Solution {
    public: int maxTwoEvents(vector<vector<int>>& events){
        sort(events.begin(),events.end());
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> heap;
        int bestEnded=0,answer=0;
        for(auto& event:events){
            while(!heap.empty()&&heap.top().first<event[0]){
                bestEnded=max(bestEnded,heap.top().second);
                heap.pop();
            }
            answer=max(answer,bestEnded+event[2]);
            heap.push({
                event[1],event[2]
            });
        }
        return answer;
    }
};
