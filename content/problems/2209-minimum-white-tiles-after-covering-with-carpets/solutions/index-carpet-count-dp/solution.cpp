class Solution {
    string floor;
    int length;
    vector<vector<int>> memo;
    int dfs(int index,int carpets){
        if(index>=(int)floor.size())return 0;
        if(!carpets)return count(floor.begin()+index,floor.end(),'1');
        if(memo[index][carpets]>=0)return memo[index][carpets];
        int skip=floor[index]-'0'+dfs(index+1,carpets);
        int cover=dfs(index+length,carpets-1);
        return memo[index][carpets]=min(skip,cover);
    }
    public:int minimumWhiteTiles(string floor,int numCarpets,int carpetLen){
        this->floor=floor;
        length=carpetLen;
        memo.assign(floor.size(),vector<int>(numCarpets+1,-1));
        return dfs(0,numCarpets);
    }
};
