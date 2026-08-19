class Solution {
    private int[][] events,memo;
    private int next(int end){
        int left=0,right=events.length;
        while(left<right){
            int mid=(left+right)>>>1;
            if(events[mid][0]<=end)left=mid+1;
            else right=mid;
        }
        return left;
    }
    private int dfs(int index,int remaining){
        if(index==events.length||remaining==0)return 0;
        if(memo[index][remaining]!=-1)return memo[index][remaining];
        return memo[index][remaining]=Math.max(dfs(index+1,remaining),events[index][2]+dfs(next(events[index][1]),remaining-1));
    }
    public int maxValue(int[][] events,int k){
        Arrays.sort(events,Comparator.comparingInt(event->event[0]));
        this.events=events;
        memo=new int[events.length][k+1];
        for(int[] row:memo)Arrays.fill(row,-1);
        return dfs(0,k);
    }
}
