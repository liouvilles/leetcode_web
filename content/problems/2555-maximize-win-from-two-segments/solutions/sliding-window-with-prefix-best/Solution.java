class Solution {
    public int maximizeWin(int[] prizePositions,int k){
        int n=prizePositions.length,left=0,answer=0;
        int[] best=new int[n+1];
        for(int right=0;right<n;right++){
            while(prizePositions[right]-prizePositions[left]>k)left++;
            int current=right-left+1;
            answer=Math.max(answer,current+best[left]);
            best[right+1]=Math.max(best[right],current);
        }
        return answer;
    }
}
