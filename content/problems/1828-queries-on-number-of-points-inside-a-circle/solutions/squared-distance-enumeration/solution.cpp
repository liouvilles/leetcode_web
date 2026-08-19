class Solution {
    public: vector<int> countPoints(vector<vector<int>>& points,vector<vector<int>>& queries){
        vector<int> answer;
        for(auto& query:queries){
            int count=0;
            for(auto& point:points){
                long long dx=point[0]-query[0],dy=point[1]-query[1],radius=query[2];
                count+=dx*dx+dy*dy<=radius*radius;
            }
            answer.push_back(count);
        }
        return answer;
    }
};
