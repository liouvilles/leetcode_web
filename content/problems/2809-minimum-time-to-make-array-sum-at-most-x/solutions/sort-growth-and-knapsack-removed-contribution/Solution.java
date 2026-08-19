class Solution {
    public int minimumTime(List<Integer> nums1,List<Integer> nums2,int x){
        int n=nums1.size();
        int[][] pairs=new int[n][2];
        long base=0,growth=0;
        for(int i=0;i<n;i++){
            pairs[i][0]=nums1.get(i);
            pairs[i][1]=nums2.get(i);
            base+=pairs[i][0];
            growth+=pairs[i][1];
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        long[] dp=new long[n+1];
        for(int i=0;i<n;i++)for(int selected=i+1;selected>=1;selected--)dp[selected]=Math.max(dp[selected],dp[selected-1]+pairs[i][0]+(long)pairs[i][1]*selected);
        for(int seconds=0;seconds<=n;seconds++)if(base+growth*seconds-dp[seconds]<=x)return seconds;
        return -1;
    }
}
