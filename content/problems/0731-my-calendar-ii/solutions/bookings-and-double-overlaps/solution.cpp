class MyCalendarTwo {
    vector<pair<int,int>> bookings,overlaps;
    public:MyCalendarTwo(){
    }
    bool book(int startTime,int endTime){
        for(auto overlap:overlaps)if(max(startTime,overlap.first)<min(endTime,overlap.second))return false;
        for(auto booking:bookings){
            int left=max(startTime,booking.first),right=min(endTime,booking.second);
            if(left<right)overlaps.push_back({
                left,right
            });
        }
        bookings.push_back({
            startTime,endTime
        });
        return true;
    }
};
