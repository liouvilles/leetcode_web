class Solution {
    public int minOperations(String s1,String s2,int x){
        List<Integer> positions=new ArrayList<>();
        for(int i=0;i<s1.length();i++)if(s1.charAt(i)!=s2.charAt(i))positions.add(i);
        int m=positions.size();
        if((m&1)==1)return -1;
        if(m==0)return 0;
        int[] dp=new int[m+1];
        dp[1]=x;
        for(int i=2;i<=m;i++)dp[i]=Math.min(dp[i-1]+x,dp[i-2]+2*(positions.get(i-1)-positions.get(i-2)));
        return dp[m]/2;
    }
}
