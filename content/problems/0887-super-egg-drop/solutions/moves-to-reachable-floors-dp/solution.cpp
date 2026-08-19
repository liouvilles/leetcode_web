class Solution {
    public: int superEggDrop(int k,int n){
        vector<long long> reachable(k+1);
        int moves=0;
        while(reachable[k]<n){
            ++moves;
            for(int eggs=k;eggs>=1;--eggs)reachable[eggs]=reachable[eggs]+reachable[eggs-1]+1;
        }
        return moves;
    }
};
