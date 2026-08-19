class Solution {
    int minutes(string time){
        return stoi(time.substr(0,2))*60+stoi(time.substr(3));
    }
    public: int numberOfRounds(string loginTime,string logoutTime){
        int start=minutes(loginTime),finish=minutes(logoutTime);
        if(finish<start)finish+=1440;
        start=(start+14)/15*15;
        finish=finish/15*15;
        return max(0,(finish-start)/15);
    }
};
