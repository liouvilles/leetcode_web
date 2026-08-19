class Solution {
    public: bool canReach(string s,int minJump,int maxJump){
        vector<bool> dp(s.size());
        dp[0]=true;
        int reachable=0;
        for(int i=1;i<(int)s.size();++i){
            if(i-minJump>=0&&dp[i-minJump])++reachable;
            if(i-maxJump-1>=0&&dp[i-maxJump-1])--reachable;
            dp[i]=s[i]=='0'&&reachable>0;
        }
        return dp.back();
    }
};
