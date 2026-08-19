class Solution {
    public double new21Game(int n,int k,int maxPts){
        if(k==0||n>=k-1+maxPts)return 1.0;
        double[] dp=new double[n+1];
        dp[0]=1.0;
        double window=1.0,answer=0.0;
        for(int score=1;score<=n;score++){
            dp[score]=window/maxPts;
            if(score<k)window+=dp[score];
            else answer+=dp[score];
            int expired=score-maxPts;
            if(expired>=0&&expired<k)window-=dp[expired];
        }
        return answer;
    }
}
