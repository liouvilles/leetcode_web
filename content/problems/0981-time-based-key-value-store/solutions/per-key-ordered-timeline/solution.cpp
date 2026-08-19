class TimeMap {
    unordered_map<string,map<int,string>> timelines;
    public:TimeMap(){
    }
    void set(string key,string value,int timestamp){
        timelines[key][timestamp]=value;
    }
    string get(string key,int timestamp){
        auto found=timelines.find(key);
        if(found==timelines.end())return "";
        auto it=found->second.upper_bound(timestamp);
        if(it==found->second.begin())return "";
        return prev(it)->second;
    }
};
