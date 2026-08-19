class Solution {
    private int dfs(int node,int parent,List<int[]>[] graph){
        int answer=0;
        for(int[] edge:graph[node])if(edge[0]!=parent)answer+=edge[1]+dfs(edge[0],node,graph);
        return answer;
    }
    public int minReorder(int n,int[][] connections){
        List<int[]>[] graph=new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:connections){
            graph[edge[0]].add(new int[]{
                edge[1],1
            });
            graph[edge[1]].add(new int[]{
                edge[0],0
            });
        }
        return dfs(0,-1,graph);
    }
}
