class Solution {
    public:long long maximumBeauty(vector<int>& flowers,long long newFlowers,int target,int full,int partial){
        sort(flowers.begin(),flowers.end());
        int n=flowers.size(),incomplete=0;
        vector<long long> prefix(n+1);
        for(int i=0;i<n;++i){
            flowers[i]=min(flowers[i],target);
            prefix[i+1]=prefix[i]+flowers[i];
            incomplete+=flowers[i]<target;
        }
        long long answer=0,fullCost=0;
        for(int remain=incomplete;remain>=0;--remain){
            if(fullCost>newFlowers)break;
            long long budget=newFlowers-fullCost,level=0;
            if(remain){
                int left=1,right=remain;
                while(left<right){
                    int middle=(left+right+1)/2;
                    long long cost=(long long)flowers[middle-1]*middle-prefix[middle];
                    if(cost<=budget)left=middle;
                    else right=middle-1;
                }
                level=min((long long)target-1,(prefix[left]+budget)/left);
            }
            answer=max(answer,(long long)(n-remain)*full+level*partial);
            if(remain)fullCost+=target-flowers[remain-1];
        }
        return answer;
    }
};
