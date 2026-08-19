class Solution {
    public:int sumDistance(vector<int>& nums,string s,int d){
        const long long MOD=1000000007;
        vector<long long> positions(nums.size());
        for(int i=0;i<(int)nums.size();++i)positions[i]=(long long)nums[i]+(s[i]=='R'?d:-d);
        sort(positions.begin(),positions.end());
        long long prefix=0,answer=0;
        for(int i=0;i<(int)positions.size();++i){
            answer=(answer+positions[i]*i-prefix)%MOD;
            prefix+=positions[i];
        }
        return answer;
    }
};
