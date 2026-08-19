class Solution {
    public int minDistance(int[] houses,int k){
        Arrays.sort(houses);
        int n=houses.length;
        int[][] segment=new int[n][n];
        for(int left=0;left<n;left++)for(int right=left;right<n;right++){
            int median=houses[(left+right)/2];
            for(int i=left;i<=right;i++)segment[left][right]+=Math.abs(houses[i]-median);
        }
        int inf=1_000_000_000;
        int[][] dp=new int[k+1][n+1];
        for(int[] row:dp)Arrays.fill(row,inf);
        dp[0][0]=0;
        for(int boxes=1;boxes<=k;boxes++)for(int count=1;count<=n;count++)for(int previous=0;previous<count;previous++)if(dp[boxes-1][previous]<inf)dp[boxes][count]=Math.min(dp[boxes][count],dp[boxes-1][previous]+segment[previous][count-1]);
        return dp[k][n];
    }
}
