class UndergroundSystem {
    unordered_map<int,pair<string,int>> active;
    unordered_map<string,pair<long long,int>> routes;
    public:void checkIn(int id,string stationName,int t){
        active[id]={
            stationName,t
        };
    }
    void checkOut(int id,string stationName,int t){
        auto start=active[id];
        active.erase(id);
        auto& aggregate=routes[start.first+"#"+stationName];
        aggregate.first+=t-start.second;
        ++aggregate.second;
    }
    double getAverageTime(string startStation,string endStation){
        auto aggregate=routes[startStation+"#"+endStation];
        return (double)aggregate.first/aggregate.second;
    }
};
