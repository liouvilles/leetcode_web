class Solution {
    public int minimumDeleteSum(String s1,String s2){
        int[] dp=new int[s2.length()+1];
        for(int j=1;j<=s2.length();j++)dp[j]=dp[j-1]+s2.charAt(j-1);
        for(int i=1;i<=s1.length();i++){
            int diagonal=dp[0];
            dp[0]+=s1.charAt(i-1);
            for(int j=1;j<=s2.length();j++){
                int above=dp[j];
                if(s1.charAt(i-1)==s2.charAt(j-1))dp[j]=diagonal;
                else dp[j]=Math.min(above+s1.charAt(i-1),dp[j-1]+s2.charAt(j-1));
                diagonal=above;
            }
        }
        return dp[s2.length()];
    }
}
