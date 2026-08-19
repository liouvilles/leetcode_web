class Solution {
    public: int heightChecker(vector<int>& heights){
        vector<int> expected=heights;
        sort(expected.begin(),expected.end());
        int mismatches=0;
        for(int i=0;i<(int)heights.size();++i)mismatches+=heights[i]!=expected[i];
        return mismatches;
    }
};
