class Solution {
    public int minCostConnectPoints(int[][] points){
        int n=points.length,answer=0;
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        boolean[] used=new boolean[n];
        for(int count=0;count<n;count++){
            int node=-1;
            for(int i=0;i<n;i++)if(!used[i]&&(node==-1||distance[i]<distance[node]))node=i;
            used[node]=true;
            answer+=distance[node];
            for(int next=0;next<n;next++)if(!used[next]){
                int cost=Math.abs(points[node][0]-points[next][0])+Math.abs(points[node][1]-points[next][1]);
                distance[next]=Math.min(distance[next],cost);
            }
        }
        return answer;
    }
}
