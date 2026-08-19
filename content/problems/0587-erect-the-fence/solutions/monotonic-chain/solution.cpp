class Solution {
    long long cross(const vector<int>& a,const vector<int>& b,const vector<int>& c){
        return 1LL*(b[0]-a[0])*(c[1]-a[1])-1LL*(b[1]-a[1])*(c[0]-a[0]);
    }
    public:vector<vector<int>> outerTrees(vector<vector<int>>& trees){
        sort(trees.begin(),trees.end());
        vector<vector<int>> lower,upper;
        for(auto& point:trees){
            while(lower.size()>=2&&cross(lower[lower.size()-2],lower.back(),point)<0)lower.pop_back();
            lower.push_back(point);
        }
        for(int i=trees.size()-1;i>=0;--i){
            auto& point=trees[i];
            while(upper.size()>=2&&cross(upper[upper.size()-2],upper.back(),point)<0)upper.pop_back();
            upper.push_back(point);
        }
        set<pair<int,int>> boundary;
        for(auto& point:lower)boundary.insert({
            point[0],point[1]
        });
        for(auto& point:upper)boundary.insert({
            point[0],point[1]
        });
        vector<vector<int>> result;
        for(auto [x,y]:boundary)result.push_back({
            x,y
        });
        return result;
    }
};
