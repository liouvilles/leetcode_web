class Solution {
    const int BOUND=1000000;
    unordered_set<long long> blocked;
    int limit;
    long long key(int r,int c){
        return(long long)r*BOUND+c;
    }
    bool search(vector<int>& start,vector<int>& finish){
        queue<pair<int,int>> pending;
        unordered_set<long long> seen{
            key(start[0],start[1])
        };
        pending.push({
            start[0],start[1]
        });
        int directions[4][2]={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        };
        while(!pending.empty()&&(int)seen.size()<=limit){
            auto cell=pending.front();
            pending.pop();
            for(auto& d:directions){
                int r=cell.first+d[0],c=cell.second+d[1];
                if(r<0||r>=BOUND||c<0||c>=BOUND)continue;
                if(r==finish[0]&&c==finish[1])return true;
                long long code=key(r,c);
                if(!blocked.count(code)&&seen.insert(code).second)pending.push({
                    r,c
                });
            }
        }
        return (int)seen.size()>limit;
    }
    public:bool isEscapePossible(vector<vector<int>>& blockedCells,vector<int>& source,vector<int>& target){
        for(auto& cell:blockedCells)blocked.insert(key(cell[0],cell[1]));
        limit=blockedCells.size()*(blockedCells.size()-1)/2;
        return search(source,target)&&search(target,source);
    }
};
