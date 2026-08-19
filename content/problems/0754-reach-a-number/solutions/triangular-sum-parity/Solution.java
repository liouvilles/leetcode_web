class Solution {
    public int reachNumber(int target){
        target=Math.abs(target);
        int step=0,sum=0;
        while(sum<target||((sum-target)&1)!=0)sum+=++step;
        return step;
    }
}
