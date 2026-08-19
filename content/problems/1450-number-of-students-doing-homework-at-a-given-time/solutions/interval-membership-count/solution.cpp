class Solution {
    public: int busyStudent(vector<int>& startTime,vector<int>& endTime,int queryTime){
        int answer=0;
        for(int i=0;i<(int)startTime.size();++i)answer+=startTime[i]<=queryTime&&queryTime<=endTime[i];
        return answer;
    }
};
