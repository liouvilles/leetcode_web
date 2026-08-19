class Solution {
    public: int maxEqualFreq(vector<int>& nums){
        unordered_map<int,int> valueCount,frequencyCount;
        int maximum=0,answer=0;
        for(int i=0;i<(int)nums.size();++i){
            int old=valueCount[nums[i]];
            if(old)--frequencyCount[old];
            int current=++valueCount[nums[i]];
            ++frequencyCount[current];
            maximum=max(maximum,current);
            int length=i+1;
            if(maximum==1||maximum*frequencyCount[maximum]+1==length||(maximum-1)*(frequencyCount[maximum-1]+1)+1==length)answer=length;
        }
        return answer;
    }
};
