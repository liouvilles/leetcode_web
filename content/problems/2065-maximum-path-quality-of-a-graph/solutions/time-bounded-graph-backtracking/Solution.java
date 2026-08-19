class Solution {
    List<int[]>[] graph;
    int[] values,visits;
    int maximumTime,answer;
    private void dfs(int node,int used,int quality){
        if(node==0)answer=Math.max(answer,quality);
        for(int[] edge:graph[node])if(used+edge[1]<=maximumTime){
            int next=edge[0],gain=visits[next]++==0?values[next]:0;
            dfs(next,used+edge[1],quality+gain);
            visits[next]--;
        }
    }
    public int maximalPathQuality(int[] values,int[][] edges,int maxTime){
        this.values=values;
        maximumTime=maxTime;
        graph=new List[values.length];
        for(int i=0;i<values.length;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(new int[]{
                edge[1],edge[2]
            });
            graph[edge[1]].add(new int[]{
                edge[0],edge[2]
            });
        }
        visits=new int[values.length];
        visits[0]=1;
        dfs(0,0,values[0]);
        return answer;
    }
}
