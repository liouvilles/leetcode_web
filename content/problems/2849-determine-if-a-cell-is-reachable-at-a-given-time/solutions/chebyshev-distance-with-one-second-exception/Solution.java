class Solution {
    public boolean isReachableAtTime(int sx,int sy,int fx,int fy,int t){
        int distance=Math.max(Math.abs(sx-fx),Math.abs(sy-fy));
        return distance<=t&&!(distance==0&&t==1);
    }
}
