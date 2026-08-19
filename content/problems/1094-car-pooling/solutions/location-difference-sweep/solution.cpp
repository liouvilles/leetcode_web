class Solution {
    public: bool carPooling(vector<vector<int>>& trips,int capacity){
        int difference[1001]={
        };
        for(auto& trip:trips){
            difference[trip[1]]+=trip[0];
            difference[trip[2]]-=trip[0];
        }
        int onboard=0;
        for(int change:difference)if((onboard+=change)>capacity)return false;
        return true;
    }
};
