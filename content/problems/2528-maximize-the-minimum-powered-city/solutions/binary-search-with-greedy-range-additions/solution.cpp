class Solution {
    vector<long long> power;
    int n,r;
    long long budget;
    bool possible(long long target){
        vector<long long> difference(n+1);
        long long active=0,used=0;
        for(int city=0;city<n;++city){
            active+=difference[city];
            long long need=target-power[city]-active;
            if(need>0){
                used+=need;
                if(used>budget)return false;
                active+=need;
                int station=min(n-1,city+r),expire=min(n,station+r+1);
                difference[expire]-=need;
            }
        }
        return true;
    }
    public:long long maxPower(vector<int>& stations,int radius,int k){
        n=stations.size();
        r=radius;
        budget=k;
        vector<long long> prefix(n+1);
        for(int i=0;i<n;++i)prefix[i+1]=prefix[i]+stations[i];
        power.resize(n);
        for(int city=0;city<n;++city)power[city]=prefix[min(n,city+r+1)]-prefix[max(0,city-r)];
        long long left=*min_element(power.begin(),power.end()),right=left+k;
        while(left<right){
            long long middle=(left+right+1)/2;
            if(possible(middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
};
