class Solution {
    public:int maximumLength(vector<int>& nums){
        unordered_map<long long,int> frequency;
        for(int value:nums)++frequency[value];
        auto count=[&](long long value){
            auto found=frequency.find(value);
            return found==frequency.end()?0:found->second;
        };
        int answer=1,ones=count(1);
        if(ones>0)answer=ones&1?ones:ones-1;
        for(const auto& entry:frequency){
            long long start=entry.first;
            if(start==1)continue;
            int length=0;
            long long value=start;
            while(count(value)>=2){
                length+=2;
                value*=value;
            }
            length+=count(value)>0?1:-1;
            answer=max(answer,length);
        }
        return answer;
    }
};
