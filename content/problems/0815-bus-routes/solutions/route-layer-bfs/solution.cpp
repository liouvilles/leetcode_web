class Solution {
    public: int numBusesToDestination(vector<vector<int>>& routes,int source,int target){
        if(source==target)return 0;
        unordered_map<int,vector<int>> stopRoutes;
        for(int route=0;route<(int)routes.size();++route)for(int stop:routes[route])stopRoutes[stop].push_back(route);
        queue<int> pending;
        unordered_set<int> seenStops{
            source
        };
        vector<bool> seenRoutes(routes.size());
        pending.push(source);
        int buses=0;
        while(!pending.empty()){
            ++buses;
            for(int size=pending.size();size;--size){
                int stop=pending.front();
                pending.pop();
                for(int route:stopRoutes[stop])if(!seenRoutes[route]){
                    seenRoutes[route]=true;
                    for(int next:routes[route]){
                        if(next==target)return buses;
                        if(seenStops.insert(next).second)pending.push(next);
                    }
                }
            }
        }
        return -1;
    }
};
