class Solution {
    public: int numPairsDivisibleBy60(vector<int>& time){
        int frequency[60]={
        },answer=0;
        for(int duration:time){
            int remainder=duration%60;
            answer+=frequency[(60-remainder)%60];
            ++frequency[remainder];
        }
        return answer;
    }
};
