class Solution {
    public int[] countOfPairs(int n,int x,int y){
        int[] answer=new int[n];
        for(int first=1;first<=n;first++)for(int second=1;second<=n;second++)if(first!=second){
            int distance=Math.min(Math.abs(first-second),Math.min(Math.abs(first-x)+1+Math.abs(y-second),Math.abs(first-y)+1+Math.abs(x-second)));
            answer[distance-1]++;
        }
        return answer;
    }
}
