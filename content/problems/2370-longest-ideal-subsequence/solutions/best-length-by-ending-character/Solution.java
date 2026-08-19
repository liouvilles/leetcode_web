class Solution {
    public int longestIdealString(String s,int k){
        int[] dp=new int[26];
        int answer=0;
        for(char ch:s.toCharArray()){
            int value=ch-'a',best=0;
            for(int previous=Math.max(0,value-k);previous<=Math.min(25,value+k);previous++)best=Math.max(best,dp[previous]);
            dp[value]=Math.max(dp[value],best+1);
            answer=Math.max(answer,dp[value]);
        }
        return answer;
    }
}
