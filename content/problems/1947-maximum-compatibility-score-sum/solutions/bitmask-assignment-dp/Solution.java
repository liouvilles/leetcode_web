class Solution {
    int[][] score;
    int[] memo;
    private int dfs(int mask){
        if(mask==memo.length-1)return 0;
        if(memo[mask]>=0)return memo[mask];
        int student=Integer.bitCount(mask),best=0;
        for(int mentor=0;mentor<score.length;mentor++)if((mask&(1<<mentor))==0)best=Math.max(best,score[student][mentor]+dfs(mask|1<<mentor));
        return memo[mask]=best;
    }
    public int maxCompatibilitySum(int[][] students,int[][] mentors){
        int n=students.length;
        score=new int[n][n];
        for(int i=0;i<n;i++)for(int j=0;j<n;j++)for(int q=0;q<students[i].length;q++)if(students[i][q]==mentors[j][q])score[i][j]++;
        memo=new int[1<<n];
        Arrays.fill(memo,-1);
        return dfs(0);
    }
}
