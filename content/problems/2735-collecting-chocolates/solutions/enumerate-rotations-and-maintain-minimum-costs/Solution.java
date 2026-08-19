class Solution {
    public long minCost(int[] nums,int x){
        int n=nums.length;
        int[] best=nums.clone();
        long answer=0;
        for(int value:best)answer+=value;
        for(int rotations=1;rotations<n;rotations++){
            long current=(long)rotations*x;
            for(int i=0;i<n;i++){
                best[i]=Math.min(best[i],nums[(i-rotations+n)%n]);
                current+=best[i];
            }
            answer=Math.min(answer,current);
        }
        return answer;
    }
}
