class Solution {
    public: int findMinArrowShots(vector<vector<int>>& points){
        sort(points.begin(),points.end(),[](const auto& a,const auto& b){
            return a[1]<b[1];
        });
        int arrows=1;
        long long position=points[0][1];
        for(int i=1;i<(int)points.size();++i)if(points[i][0]>position){
            ++arrows;
            position=points[i][1];
        }
        return arrows;
    }
};
