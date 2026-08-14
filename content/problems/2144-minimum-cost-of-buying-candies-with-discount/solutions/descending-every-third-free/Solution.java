class Solution { public int minimumCost(int[] cost){Arrays.sort(cost);int answer=0,position=0;for(int i=cost.length-1;i>=0;i--,position++)if(position%3!=2)answer+=cost[i];return answer;} }
