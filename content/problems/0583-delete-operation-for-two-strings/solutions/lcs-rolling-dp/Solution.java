class Solution {
    public int minDistance(String word1,String word2){
        int[] dp=new int[word2.length()+1];
        for(int i=1;i<=word1.length();i++){
            int diagonal=0;
            for(int j=1;j<=word2.length();j++){
                int above=dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1))dp[j]=diagonal+1;
                else dp[j]=Math.max(dp[j],dp[j-1]);
                diagonal=above;
            }
        }
        return word1.length()+word2.length()-2*dp[word2.length()];
    }
}
