class Solution {
    public:long long minimumSteps(string s){
        long long ones=0,answer=0;
        for(char ball:s)if(ball=='1')++ones;
        else answer+=ones;
        return answer;
    }
};
