class Solution {
    public int minimumBeautifulSubstrings(String s){
        Set<Long> powers=new HashSet<>();
        long limit=1L<<s.length();
        for(long value=1;value<limit;value*=5)powers.add(value);
        int inf=1000000,n=s.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp,inf);
        dp[0]=0;
        for(int start=0;start<n;start++)if(dp[start]<inf&&s.charAt(start)!='0'){
            long value=0;
            for(int end=start;end<n;end++){
                value=value*2+s.charAt(end)-'0';
                if(powers.contains(value))dp[end+1]=Math.min(dp[end+1],dp[start]+1);
            }
        }
        return dp[n]==inf?-1:dp[n];
    }
}
