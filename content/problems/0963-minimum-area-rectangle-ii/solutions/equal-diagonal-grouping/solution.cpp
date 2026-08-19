class Solution {
    public: double minAreaFreeRect(vector<vector<int>>& points){
        unordered_map<string,vector<pair<int,int>>> groups;
        for(int i=0;i<(int)points.size();++i)for(int j=i+1;j<(int)points.size();++j){
            long long dx=points[i][0]-points[j][0],dy=points[i][1]-points[j][1];
            string key=to_string(points[i][0]+points[j][0])+","+to_string(points[i][1]+points[j][1])+","+to_string(dx*dx+dy*dy);
            groups[key].push_back({
                i,j
            });
        }
        double answer=DBL_MAX;
        for(auto& entry:groups){
            auto& group=entry.second;
            for(int a=0;a<(int)group.size();++a)for(int b=a+1;b<(int)group.size();++b){
                auto& p=points[group[a].first];
                auto& q=points[group[b].first];
                auto& r=points[group[b].second];
                long long area=llabs((long long)(q[0]-p[0])*(r[1]-p[1])-(long long)(q[1]-p[1])*(r[0]-p[0]));
                if(area)answer=min(answer,(double)area);
            }
        }
        return answer==DBL_MAX?0:answer;
    }
};
