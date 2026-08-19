class Solution {
    public int orderOfLargestPlusSign(int n,int[][] mines){
        boolean[][] blocked=new boolean[n][n];
        for(int[] mine:mines)blocked[mine[0]][mine[1]]=true;
        int[][] dp=new int[n][n];
        for(int[] row:dp)Arrays.fill(row,n);
        for(int r=0;r<n;r++){
            int count=0;
            for(int c=0;c<n;c++){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=Math.min(dp[r][c],count);
            }
            count=0;
            for(int c=n-1;c>=0;c--){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=Math.min(dp[r][c],count);
            }
        }
        for(int c=0;c<n;c++){
            int count=0;
            for(int r=0;r<n;r++){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=Math.min(dp[r][c],count);
            }
            count=0;
            for(int r=n-1;r>=0;r--){
                count=blocked[r][c]?0:count+1;
                dp[r][c]=Math.min(dp[r][c],count);
            }
        }
        int answer=0;
        for(int[] row:dp)for(int value:row)answer=Math.max(answer,value);
        return answer;
    }
}
