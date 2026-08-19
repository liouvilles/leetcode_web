class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles,int k){
        int negative=-1_000_000_000;
        int[] dp=new int[k+1];
        Arrays.fill(dp,negative);
        dp[0]=0;
        for(List<Integer> pile:piles){
            int[] next=dp.clone();
            int prefix=0;
            for(int take=1;take<=Math.min(k,pile.size());take++){
                prefix+=pile.get(take-1);
                for(int used=0;used+take<=k;used++)if(dp[used]>negative)next[used+take]=Math.max(next[used+take],dp[used]+prefix);
            }
            dp=next;
        }
        return dp[k];
    }
}
