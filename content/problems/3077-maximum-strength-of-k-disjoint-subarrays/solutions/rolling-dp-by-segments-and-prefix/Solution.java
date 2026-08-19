class Solution {
    public long maximumStrength(int[] nums,int k){
        int n=nums.length;
        long negative=Long.MIN_VALUE/4;
        long[] previous=new long[n+1];
        for(int part=1;part<=k;part++){
            long[] current=new long[n+1];
            Arrays.fill(current,negative);
            long coefficient=(long)(k-part+1)*(part%2==1?1:-1);
            long bestEnding=negative;
            for(int position=part;position<=n;position++){
                long value=coefficient*nums[position-1];
                bestEnding=Math.max(bestEnding+value,previous[position-1]+value);
                current[position]=Math.max(current[position-1],bestEnding);
            }
            previous=current;
        }
        return previous[n];
    }
}
