class Solution {
    public: int numSubmat(vector<vector<int>>& mat){
        int cols=mat[0].size(),answer=0;
        vector<int> height(cols);
        for(auto& row:mat){
            for(int col=0;col<cols;++col)height[col]=row[col]?height[col]+1:0;
            for(int right=0;right<cols;++right){
                int minimum=INT_MAX;
                for(int left=right;left>=0;--left){
                    minimum=min(minimum,height[left]);
                    answer+=minimum;
                }
            }
        }
        return answer;
    }
};
