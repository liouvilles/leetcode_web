class Solution {
    public: int largestSubmatrix(vector<vector<int>>& matrix){
        int cols=matrix[0].size(),answer=0;
        vector<int> heights(cols);
        for(auto& row:matrix){
            for(int col=0;col<cols;++col)heights[col]=row[col]?heights[col]+1:0;
            auto sorted=heights;
            sort(sorted.rbegin(),sorted.rend());
            for(int index=0;index<cols;++index)answer=max(answer,sorted[index]*(index+1));
        }
        return answer;
    }
};
