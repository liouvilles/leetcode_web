class Solution {
    public: int rectangleArea(vector<vector<int>>& rectangles){
        const long long mod=1000000007;
        long long area=0;
        set<int> xSet;
        for(auto& rectangle:rectangles){
            xSet.insert(rectangle[0]);
            xSet.insert(rectangle[2]);
        }
        vector<int> xs(xSet.begin(),xSet.end());
        for(int i=0;i+1<(int)xs.size();++i){
            int left=xs[i],right=xs[i+1];
            vector<pair<int,int>> intervals;
            for(auto& rectangle:rectangles)if(rectangle[0]<=left&&rectangle[2]>=right)intervals.push_back({
                rectangle[1],rectangle[3]
            });
            sort(intervals.begin(),intervals.end());
            long long covered=0;
            int start=0,end=0;
            bool active=false;
            for(auto interval:intervals){
                if(!active){
                    start=interval.first;
                    end=interval.second;
                    active=true;
                }else if(interval.first>end){
                    covered+=end-start;
                    start=interval.first;
                    end=interval.second;
                }else end=max(end,interval.second);
            }
            if(active)covered+=end-start;
            area=(area+(long long)(right-left)*covered)%mod;
        }
        return area;
    }
};
