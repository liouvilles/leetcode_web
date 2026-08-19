class Solution {
    public String shortestCommonSupersequence(String str1,String str2){
        int m=str1.length(),n=str2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=m-1;i>=0;i--)for(int j=n-1;j>=0;j--)dp[i][j]=str1.charAt(i)==str2.charAt(j)?dp[i+1][j+1]+1:Math.max(dp[i+1][j],dp[i][j+1]);
        StringBuilder answer=new StringBuilder();
        int i=0,j=0;
        while(i<m&&j<n)if(str1.charAt(i)==str2.charAt(j)){
            answer.append(str1.charAt(i++));
            j++;
        }else if(dp[i+1][j]>=dp[i][j+1])answer.append(str1.charAt(i++));
        else answer.append(str2.charAt(j++));
        return answer.append(str1.substring(i)).append(str2.substring(j)).toString();
    }
}
