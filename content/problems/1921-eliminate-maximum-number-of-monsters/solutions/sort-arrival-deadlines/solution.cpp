class Solution {
    public: int eliminateMaximum(vector<int>& dist,vector<int>& speed){
        vector<int> arrival(dist.size());
        for(int i=0;i<(int)dist.size();++i)arrival[i]=(dist[i]+speed[i]-1)/speed[i];
        sort(arrival.begin(),arrival.end());
        for(int i=0;i<(int)arrival.size();++i)if(arrival[i]<=i)return i;
        return arrival.size();
    }
};
