class Solution {
    public:long long getMaxFunctionValue(vector<int>& receiver,long long k){
        int n=receiver.size(),levels=61;
        vector jump(levels,vector<int>(n));
        vector sum(levels,vector<long long>(n));
        for(int node=0;node<n;++node){
            jump[0][node]=receiver[node];
            sum[0][node]=receiver[node];
        }
        for(int bit=1;bit<levels;++bit)for(int node=0;node<n;++node){
            int middle=jump[bit-1][node];
            jump[bit][node]=jump[bit-1][middle];
            sum[bit][node]=sum[bit-1][node]+sum[bit-1][middle];
        }
        long long answer=0;
        for(int start=0;start<n;++start){
            int node=start;
            long long value=start;
            for(int bit=0;bit<levels;++bit)if(k>>bit&1){
                value+=sum[bit][node];
                node=jump[bit][node];
            }
            answer=max(answer,value);
        }
        return answer;
    }
};
