class Solution {
    public: int slidingPuzzle(vector<vector<int>>& board){
        string start;
        for(auto& row:board)for(int value:row)start+=char('0'+value);
        string target="123450";
        vector<vector<int>> neighbors={
            {
                1,3
            },{
                0,2,4
            },{
                1,5
            },{
                0,4
            },{
                1,3,5
            },{
                2,4
            }
        };
        queue<pair<string,int>> pending;
        unordered_set<string> visited{
            start
        };
        pending.push({
            start,0
        });
        while(!pending.empty()){
            auto [state,distance]=pending.front();
            pending.pop();
            if(state==target)return distance;
            int zero=state.find('0');
            for(int next:neighbors[zero]){
                string candidate=state;
                swap(candidate[zero],candidate[next]);
                if(visited.insert(candidate).second)pending.push({
                    candidate,distance+1
                });
            }
        }
        return -1;
    }
};
