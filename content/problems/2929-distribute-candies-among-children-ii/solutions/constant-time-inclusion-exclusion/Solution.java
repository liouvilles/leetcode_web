class Solution {
    private long ways(long sum){
        return sum<0?0:(sum+1)*(sum+2)/2;
    }
    public long distributeCandies(int n,int limit){
        long step=limit+1L;
        return ways(n)-3*ways(n-step)+3*ways(n-2*step)-ways(n-3*step);
    }
}
