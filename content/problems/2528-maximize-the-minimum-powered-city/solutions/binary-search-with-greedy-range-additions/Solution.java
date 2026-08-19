class Solution {
    private long[] power;
    private int n,r;
    private long budget;
    private boolean possible(long target){
        long[] difference=new long[n+1];
        long active=0,used=0;
        for(int city=0;city<n;city++){
            active+=difference[city];
            long need=target-power[city]-active;
            if(need>0){
                used+=need;
                if(used>budget)return false;
                active+=need;
                int station=Math.min(n-1,city+r);
                int expire=Math.min(n,station+r+1);
                difference[expire]-=need;
            }
        }
        return true;
    }
    public long maxPower(int[] stations,int r,int k){
        n=stations.length;
        this.r=r;
        budget=k;
        long[] prefix=new long[n+1];
        for(int i=0;i<n;i++)prefix[i+1]=prefix[i]+stations[i];
        power=new long[n];
        for(int city=0;city<n;city++)power[city]=prefix[Math.min(n,city+r+1)]-prefix[Math.max(0,city-r)];
        long left=Arrays.stream(power).min().getAsLong(),right=left+k;
        while(left<right){
            long middle=(left+right+1)/2;
            if(possible(middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
}
