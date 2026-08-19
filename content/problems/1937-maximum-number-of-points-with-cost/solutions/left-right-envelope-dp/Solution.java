class Solution {
    public long maxPoints(int[][] points){
        int cols=points[0].length;
        long[] dp=new long[cols];
        for(int col=0;col<cols;col++)dp[col]=points[0][col];
        for(int row=1;row<points.length;row++){
            long[] left=new long[cols],right=new long[cols],next=new long[cols];
            left[0]=dp[0];
            for(int col=1;col<cols;col++)left[col]=Math.max(dp[col],left[col-1]-1);
            right[cols-1]=dp[cols-1];
            for(int col=cols-2;col>=0;col--)right[col]=Math.max(dp[col],right[col+1]-1);
            for(int col=0;col<cols;col++)next[col]=points[row][col]+Math.max(left[col],right[col]);
            dp=next;
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}
