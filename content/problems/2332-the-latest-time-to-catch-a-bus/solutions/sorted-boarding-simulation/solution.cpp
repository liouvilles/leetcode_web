class Solution {
    public:int latestTimeCatchTheBus(vector<int>& buses,vector<int>& passengers,int capacity){
        sort(buses.begin(),buses.end());
        sort(passengers.begin(),passengers.end());
        int index=0,candidate=0;
        for(int busIndex=0;busIndex<(int)buses.size();++busIndex){
            int boarded=0;
            while(index<(int)passengers.size()&&passengers[index]<=buses[busIndex]&&boarded<capacity){
                ++index;
                ++boarded;
            }
            if(busIndex+1==(int)buses.size())candidate=boarded<capacity?buses[busIndex]:passengers[index-1]-1;
        }
        unordered_set<int> occupied(passengers.begin(),passengers.end());
        while(occupied.count(candidate))--candidate;
        return candidate;
    }
};
