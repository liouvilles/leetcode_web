class Solution {
    public: bool isCovered(vector<vector<int>>& ranges,int left,int right){
        int difference[52]={
        };
        for(auto& range:ranges){
            ++difference[range[0]];
            --difference[range[1]+1];
        }
        int coverage=0;
        for(int value=1;value<=right;++value){
            coverage+=difference[value];
            if(value>=left&&!coverage)return false;
        }
        return true;
    }
};
