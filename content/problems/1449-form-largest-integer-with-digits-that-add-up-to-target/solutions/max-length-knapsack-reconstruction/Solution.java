class Solution {
    public String largestNumber(int[] cost,int target){
        int negative=-1_000_000;
        int[] dp=new int[target+1];
        Arrays.fill(dp,negative);
        dp[0]=0;
        for(int total=1;total<=target;total++)for(int digit=1;digit<=9;digit++)if(total>=cost[digit-1]&&dp[total-cost[digit-1]]!=negative)dp[total]=Math.max(dp[total],dp[total-cost[digit-1]]+1);
        if(dp[target]<0)return "0";
        StringBuilder answer=new StringBuilder();
        int remaining=target;
        for(int digit=9;digit>=1;digit--)while(remaining>=cost[digit-1]&&dp[remaining]==dp[remaining-cost[digit-1]]+1){
            answer.append(digit);
            remaining-=cost[digit-1];
        }
        return answer.toString();
    }
}
