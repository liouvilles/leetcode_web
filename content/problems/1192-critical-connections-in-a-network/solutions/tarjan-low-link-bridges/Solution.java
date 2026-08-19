class Solution {
    private List<List<Integer>> graph,answer;
    private int[] discovery,low;
    private int time=1;
    public List<List<Integer>> criticalConnections(int n,List<List<Integer>> connections){
        graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(List<Integer> edge:connections){
            int a=edge.get(0),b=edge.get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        answer=new ArrayList<>();
        discovery=new int[n];
        low=new int[n];
        dfs(0,-1);
        return answer;
    }
    private void dfs(int node,int parent){
        discovery[node]=low[node]=time++;
        for(int next:graph.get(node)){
            if(next==parent)continue;
            if(discovery[next]==0){
                dfs(next,node);
                low[node]=Math.min(low[node],low[next]);
                if(low[next]>discovery[node])answer.add(Arrays.asList(node,next));
            }else low[node]=Math.min(low[node],discovery[next]);
        }
    }
}
