class Solution {
    public: int maxDistance(vector<vector<int>>& arrays){
        int minimum=arrays[0][0],maximum=arrays[0].back(),best=0;
        for(int i=1;i<(int)arrays.size();++i){
            int first=arrays[i][0],last=arrays[i].back();
            best=max({
                best,abs(last-minimum),abs(maximum-first)
            });
            minimum=min(minimum,first);
            maximum=max(maximum,last);
        }
        return best;
    }
};
