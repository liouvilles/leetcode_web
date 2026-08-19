class Solution {
    public int longestPalindromeSubseq(String s){
        int[] dp=new int[s.length()];
        for(int i=s.length()-1;i>=0;i--){
            dp[i]=1;
            int previous=0;
            for(int j=i+1;j<s.length();j++){
                int old=dp[j];
                dp[j]=s.charAt(i)==s.charAt(j)?previous+2:Math.max(dp[j],dp[j-1]);
                previous=old;
            }
        }
        return dp[s.length()-1];
    }
}
