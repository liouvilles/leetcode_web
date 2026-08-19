class Solution {
    public int minStickers(String[] stickers,String target){
        int full=(1<<target.length())-1;
        int[] dp=new int[full+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int mask=0;mask<=full;mask++){
            if(dp[mask]==Integer.MAX_VALUE)continue;
            for(String sticker:stickers){
                int[] counts=new int[26];
                for(char c:sticker.toCharArray())counts[c-'a']++;
                int next=mask;
                for(int i=0;i<target.length();i++)if((next&(1<<i))==0&&counts[target.charAt(i)-'a']>0){
                    counts[target.charAt(i)-'a']--;
                    next|=1<<i;
                }
                if(next!=mask)dp[next]=Math.min(dp[next],dp[mask]+1);
            }
        }
        return dp[full]==Integer.MAX_VALUE?-1:dp[full];
    }
}
