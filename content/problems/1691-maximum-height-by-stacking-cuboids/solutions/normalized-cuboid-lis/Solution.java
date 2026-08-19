class Solution {
    public int maxHeight(int[][] cuboids){
        for(int[] cuboid:cuboids)Arrays.sort(cuboid);
        Arrays.sort(cuboids,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]!=b[1]?a[1]-b[1]:a[2]-b[2]);
        int[] dp=new int[cuboids.length];
        int answer=0;
        for(int i=0;i<cuboids.length;i++){
            dp[i]=cuboids[i][2];
            for(int j=0;j<i;j++)if(cuboids[j][0]<=cuboids[i][0]&&cuboids[j][1]<=cuboids[i][1]&&cuboids[j][2]<=cuboids[i][2])dp[i]=Math.max(dp[i],dp[j]+cuboids[i][2]);
            answer=Math.max(answer,dp[i]);
        }
        return answer;
    }
}
