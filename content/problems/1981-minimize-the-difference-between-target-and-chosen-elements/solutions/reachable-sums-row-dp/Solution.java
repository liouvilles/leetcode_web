class Solution {
    public int minimizeTheDifference(int[][] mat,int target){
        int maximum=0;
        for(int[] row:mat)maximum+=Arrays.stream(row).max().getAsInt();
        boolean[] reachable=new boolean[maximum+1];
        reachable[0]=true;
        int limit=0;
        for(int[] row:mat){
            boolean[] next=new boolean[maximum+1];
            for(int sum=0;sum<=limit;sum++)if(reachable[sum])for(int value:row)next[sum+value]=true;
            limit+=Arrays.stream(row).max().getAsInt();
            reachable=next;
        }
        int answer=Integer.MAX_VALUE;
        for(int sum=0;sum<=maximum;sum++)if(reachable[sum])answer=Math.min(answer,Math.abs(sum-target));
        return answer;
    }
}
