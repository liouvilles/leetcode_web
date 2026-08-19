class Solution {
    public:long long minCost(vector<int>& nums,int x){
        int n=nums.size();
        vector<int> best=nums;
        long long answer=accumulate(best.begin(),best.end(),0LL);
        for(int rotations=1;rotations<n;++rotations){
            long long current=1LL*rotations*x;
            for(int i=0;i<n;++i){
                best[i]=min(best[i],nums[(i-rotations+n)%n]);
                current+=best[i];
            }
            answer=min(answer,current);
        }
        return answer;
    }
};
