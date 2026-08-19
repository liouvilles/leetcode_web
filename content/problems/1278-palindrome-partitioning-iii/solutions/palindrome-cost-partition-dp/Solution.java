class Solution {
    private int[][] cost,memo;
    private int n;
    public int palindromePartition(String s,int k){
        n=s.length();
        cost=new int[n][n];
        for(int length=2;length<=n;length++)for(int left=0;left+length<=n;left++){
            int right=left+length-1;
            cost[left][right]=(length>2?cost[left+1][right-1]:0)+(s.charAt(left)==s.charAt(right)?0:1);
        }
        memo=new int[n][k+1];
        for(int[] row:memo)Arrays.fill(row,-1);
        return dfs(0,k);
    }
    private int dfs(int index,int parts){
        if(parts==1)return cost[index][n-1];
        if(memo[index][parts]>=0)return memo[index][parts];
        int best=1000000;
        for(int end=index;end<=n-parts;end++)best=Math.min(best,cost[index][end]+dfs(end+1,parts-1));
        return memo[index][parts]=best;
    }
}
