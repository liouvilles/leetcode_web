class Solution {
    private int[][] buildCosts(String s){
        int n=s.length(),INF=1000000;
        int[][] mismatchPrefix=new int[n][n+1];
        for(int gap=1;gap<n;gap++)for(int index=0;index+gap<n;index++)mismatchPrefix[gap][index+1]=mismatchPrefix[gap][index]+(s.charAt(index)==s.charAt(index+gap)?0:1);
        int[][] change=new int[n][n];
        for(int[] row:change)Arrays.fill(row,INF);
        int[][] divisorCost=new int[n][n];
        for(int divisor=1;2*divisor<=n;divisor++)for(int length=2*divisor;length<=n;length+=divisor){
            int gap=length-divisor;
            for(int left=0;left+length<=n;left++){
                int right=left+length-1;
                int cost=mismatchPrefix[gap][left+divisor]-mismatchPrefix[gap][left];
                if(length>=4*divisor)cost+=divisorCost[left+divisor][right-divisor];
                divisorCost[left][right]=cost;
                change[left][right]=Math.min(change[left][right],cost);
            }
        }
        return change;
    }
    public int minimumChanges(String s,int k){
        int n=s.length(),INF=1000000;
        int[][] change=buildCosts(s);
        int[] previous=new int[n+1];
        Arrays.fill(previous,INF);
        previous[0]=0;
        for(int parts=1;parts<=k;parts++){
            int[] current=new int[n+1];
            Arrays.fill(current,INF);
            int minimumEnd=2*parts,maximumEnd=n-2*(k-parts);
            for(int end=minimumEnd;end<=maximumEnd;end++)for(int start=2*(parts-1);start<=end-2;start++)if(previous[start]<INF)current[end]=Math.min(current[end],previous[start]+change[start][end-1]);
            previous=current;
        }
        return previous[n];
    }
}
