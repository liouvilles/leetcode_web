class Solution {
    public: vector<int> closestRoom(vector<vector<int>>& rooms,vector<vector<int>>& queries){
        sort(rooms.begin(),rooms.end(),[](auto& a,auto& b){
            return a[1]>b[1];
        });
        vector<int> order(queries.size());
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return queries[a][1]>queries[b][1];
        });
        set<int> ids;
        vector<int> answer(queries.size(),-1);
        int room=0;
        for(int index:order){
            while(room<(int)rooms.size()&&rooms[room][1]>=queries[index][1])ids.insert(rooms[room++][0]);
            if(ids.empty())continue;
            int preferred=queries[index][0];
            auto high=ids.lower_bound(preferred);
            if(high!=ids.end())answer[index]=*high;
            if(high!=ids.begin()){
                int low=*prev(high);
                if(answer[index]<0||preferred-low<=answer[index]-preferred)answer[index]=low;
            }
        }
        return answer;
    }
};
