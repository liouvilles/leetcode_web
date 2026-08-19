class Solution {
    public: string largestNumber(vector<int>& cost,int target){
        const int negative=-1000000;
        vector<int> dp(target+1,negative);
        dp[0]=0;
        for(int total=1;total<=target;++total)for(int digit=1;digit<=9;++digit)if(total>=cost[digit-1]&&dp[total-cost[digit-1]]!=negative)dp[total]=max(dp[total],dp[total-cost[digit-1]]+1);
        if(dp[target]<0)return "0";
        string answer;
        int remaining=target;
        for(int digit=9;digit>=1;--digit)while(remaining>=cost[digit-1]&&dp[remaining]==dp[remaining-cost[digit-1]]+1){
            answer+=char('0'+digit);
            remaining-=cost[digit-1];
        }
        return answer;
    }
};
