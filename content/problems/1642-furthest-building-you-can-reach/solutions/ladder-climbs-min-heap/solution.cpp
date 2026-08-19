class Solution {
    public: int furthestBuilding(vector<int>& heights,int bricks,int ladders){
        priority_queue<int,vector<int>,greater<int>> climbs;
        for(int i=0;i+1<(int)heights.size();++i){
            int climb=heights[i+1]-heights[i];
            if(climb<=0)continue;
            climbs.push(climb);
            if((int)climbs.size()>ladders){
                bricks-=climbs.top();
                climbs.pop();
            }
            if(bricks<0)return i;
        }
        return heights.size()-1;
    }
};
