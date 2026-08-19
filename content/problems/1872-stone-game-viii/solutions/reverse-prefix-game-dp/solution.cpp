class Solution {
    public: int stoneGameVIII(vector<int>& stones){
        vector<int> prefix(stones.size());
        partial_sum(stones.begin(),stones.end(),prefix.begin());
        int best=prefix.back();
        for(int i=stones.size()-2;i>=1;--i)best=max(best,prefix[i]-best);
        return best;
    }
};
