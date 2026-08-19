class Solution {
    public int minDeletionSize(String[] strs){
        int columns=strs[0].length();
        int[] dp=new int[columns];
        Arrays.fill(dp,1);
        int longest=1;
        for(int j=0;j<columns;j++)for(int i=0;i<j;i++){
            boolean compatible=true;
            for(String word:strs)if(word.charAt(i)>word.charAt(j)){
                compatible=false;
                break;
            }
            if(compatible)dp[j]=Math.max(dp[j],dp[i]+1);
            longest=Math.max(longest,dp[j]);
        }
        return columns-longest;
    }
}
