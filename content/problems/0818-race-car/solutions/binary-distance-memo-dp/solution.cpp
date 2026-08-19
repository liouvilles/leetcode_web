class Solution {
    unordered_map<int,int> memo;
    public:int racecar(int target){
        if(memo.count(target))return memo[target];
        int n=32-__builtin_clz(target);
        if((1<<n)-1==target)return n;
        int answer=n+1+racecar((1<<n)-1-target),forward=(1<<(n-1))-1;
        for(int m=0;m<n-1;++m){
            int backward=(1<<m)-1;
            answer=min(answer,n+m+1+racecar(target-forward+backward));
        }
        return memo[target]=answer;
    }
};
