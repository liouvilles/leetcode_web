class Solution {
    public: int unhappyFriends(int n,vector<vector<int>>& preferences,vector<vector<int>>& pairs){
        vector<vector<int>> rank(n,vector<int>(n));
        for(int person=0;person<n;++person)for(int order=0;order<n-1;++order)rank[person][preferences[person][order]]=order;
        vector<int> partner(n);
        for(auto& pair:pairs){
            partner[pair[0]]=pair[1];
            partner[pair[1]]=pair[0];
        }
        int answer=0;
        for(int x=0;x<n;++x)for(int u:preferences[x]){
            if(u==partner[x])break;
            if(rank[u][x]<rank[u][partner[u]]){
                ++answer;
                break;
            }
        }
        return answer;
    }
};
