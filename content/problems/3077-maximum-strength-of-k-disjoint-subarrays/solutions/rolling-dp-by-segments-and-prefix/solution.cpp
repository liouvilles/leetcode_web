class Solution {
public:
    long long maximumStrength(vector<int>& nums,int k){
        int n=nums.size();
        long long negative=LLONG_MIN/4;
        vector<long long> previous(n+1);
        for(int part=1;part<=k;++part){
            vector<long long> current(n+1,negative);
            long long coefficient=(long long)(k-part+1)*(part%2?1:-1);
            long long bestEnding=negative;
            for(int position=part;position<=n;++position){
                long long value=coefficient*nums[position-1];
                bestEnding=max(bestEnding+value,previous[position-1]+value);
                current[position]=max(current[position-1],bestEnding);
            }
            previous.swap(current);
        }
        return previous[n];
    }
};
