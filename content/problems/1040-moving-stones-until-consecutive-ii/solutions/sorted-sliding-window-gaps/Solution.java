class Solution {
    public int[] numMovesStonesII(int[] stones){
        Arrays.sort(stones);
        int n=stones.length,maximum=Math.max(stones[n-2]-stones[0],stones[n-1]-stones[1])-(n-2),minimum=n,left=0;
        for(int right=0;right<n;right++){
            while(stones[right]-stones[left]+1>n)left++;
            int count=right-left+1;
            minimum=Math.min(minimum,count==n-1&&stones[right]-stones[left]==n-2?2:n-count);
        }
        return new int[]{
            minimum,maximum
        };
    }
}
