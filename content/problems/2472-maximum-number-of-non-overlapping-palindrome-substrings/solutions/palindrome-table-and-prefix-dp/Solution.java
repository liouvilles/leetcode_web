class Solution {
    public int maxPalindromes(String s,int k){
        int n=s.length();
        boolean[][] palindrome=new boolean[n][n];
        for(int left=n-1;left>=0;left--)for(int right=left;right<n;right++)palindrome[left][right]=s.charAt(left)==s.charAt(right)&&(right-left<2||palindrome[left+1][right-1]);
        int[] dp=new int[n+1];
        for(int end=0;end<n;end++){
            dp[end+1]=dp[end];
            for(int length=k;length<=k+1;length++){
                int start=end-length+1;
                if(start>=0&&palindrome[start][end])dp[end+1]=Math.max(dp[end+1],dp[start]+1);
            }
        }
        return dp[n];
    }
}
