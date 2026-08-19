class Solution {
    public: int largestOverlap(vector<vector<int>>& img1,vector<vector<int>>& img2){
        vector<pair<int,int>> first,second;
        for(int r=0;r<(int)img1.size();++r)for(int c=0;c<(int)img1.size();++c){
            if(img1[r][c])first.push_back({
                r,c
            });
            if(img2[r][c])second.push_back({
                r,c
            });
        }
        map<pair<int,int>,int> counts;
        int answer=0;
        for(auto a:first)for(auto b:second)answer=max(answer,++counts[{
            a.first-b.first,a.second-b.second
        }]);
        return answer;
    }
};
