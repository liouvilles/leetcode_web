class Solution {
    public: vector<vector<int>> kClosest(vector<vector<int>>& points,int k){
        sort(points.begin(),points.end(),[](auto& a,auto& b){
            return (long long)a[0]*a[0]+(long long)a[1]*a[1]<(long long)b[0]*b[0]+(long long)b[1]*b[1];
        });
        return {
            points.begin(),points.begin()+k
        };
    }
};
