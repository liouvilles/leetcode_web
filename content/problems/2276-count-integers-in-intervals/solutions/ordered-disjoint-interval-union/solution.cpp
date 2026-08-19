class CountIntervals {
    map<int,int> intervals;
    long long covered=0;
    public:CountIntervals(){
    }
    void add(int left,int right){
        auto iterator=intervals.upper_bound(left);
        if(iterator!=intervals.begin()){
            auto previous=prev(iterator);
            if(previous->second+1>=left)iterator=previous;
        }while(iterator!=intervals.end()&&iterator->first<=right+1){
            left=min(left,iterator->first);
            right=max(right,iterator->second);
            covered-=iterator->second-iterator->first+1LL;
            iterator=intervals.erase(iterator);
        }
        intervals[left]=right;
        covered+=right-left+1LL;
    }
    int count(){
        return covered;
    }
};
